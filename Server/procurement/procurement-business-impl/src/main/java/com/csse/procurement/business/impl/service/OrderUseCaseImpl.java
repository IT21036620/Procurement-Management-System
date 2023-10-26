package com.csse.procurement.business.impl.service;

import com.csse.procurement.business.entity.*;
import com.csse.procurement.business.exception.BusinessLogicException;
import com.csse.procurement.business.port.in.OrderUseCase;
import com.csse.procurement.business.port.out.GetPurchaseOrderPort;
import com.csse.procurement.business.port.out.GetRequisitionPort;
import com.csse.procurement.business.port.out.SavePurchaseOrderPort;
import com.csse.procurement.business.port.out.SaveRequisitionPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderUseCaseImpl implements OrderUseCase {
    private static final String PURCHASE_ORDER_NOT_FOUND = "Purchase order not found";
    private static final String PURCHASE_ORDER_ITEM_NOT_FOUND = "Purchase order item not found";
    private static final String REQUISITION_NOT_FOUND = "Requisition officer not found";

    @Autowired
    private SavePurchaseOrderPort savePurchaseOrderPort;
    @Autowired
    private GetPurchaseOrderPort getPurchaseOrderPort;
    @Autowired
    private SaveRequisitionPort saveRequisitionPort;
    @Autowired
    private GetRequisitionPort getRequisitionPort;

    @Override
    public void createPurchaseOrder(PurchaseOrder purchaseOrder) {
        savePurchaseOrderPort.createPurchaseOrder(purchaseOrder);
    }

    @Override
    public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
        PurchaseOrder existingPurchaseOrder = getPurchaseOrderPort.getPurchaseOrderById(purchaseOrder.getId());

        if (existingPurchaseOrder == null) {
            throw new BusinessLogicException(PURCHASE_ORDER_NOT_FOUND);
        }

        savePurchaseOrderPort.updatePurchaseOrder(purchaseOrder);
    }

    @Override
    public void deletePurchaseOrderById(Long id) {
        savePurchaseOrderPort.deletePurchaseOrderById(id);
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        List<PurchaseOrder> purchaseOrders = getPurchaseOrderPort.getAllPurchaseOrders();

        if (purchaseOrders == null) {
            return null;
        }

        for (PurchaseOrder purchaseOrder : purchaseOrders) {
            Long id = purchaseOrder.getId();
            List<PurchaseOrderItem> purchaseOrderItems = getPurchaseOrderPort.getAllPoItemsByPoId(id);

            if (purchaseOrderItems != null && !purchaseOrderItems.isEmpty()) {
                purchaseOrder.setPurchaseOrderItemList(purchaseOrderItems);
            }
        }

        return purchaseOrders.stream().toList();
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        PurchaseOrder purchaseOrder = getPurchaseOrderPort.getPurchaseOrderById(id);
        if (purchaseOrder == null) {
            return null;
        }

        Long poId = purchaseOrder.getId();
        List<PurchaseOrderItem> purchaseOrderItems = getPurchaseOrderPort.getAllPoItemsByPoId(poId);

        for (PurchaseOrderItem purchaseOrderItem : purchaseOrderItems) {
            if (purchaseOrderItem != null) {
                purchaseOrder.setPurchaseOrderItemList(purchaseOrderItems);
            }
        }

        return purchaseOrder;
    }

    @Override
    public void createRequisition(Requisition requisition) {
        saveRequisitionPort.createRequisition(requisition);
    }

    @Override
    public void updateRequisition(Requisition requisition) {
        Requisition existingRequisition = getRequisitionPort.getRequisitionById(requisition.getId());

        if (existingRequisition == null) {
            throw new BusinessLogicException(REQUISITION_NOT_FOUND);
        }

        saveRequisitionPort.updateRequisition(requisition);
    }

    @Override
    public void deleteRequisitionById(Long id) {
        saveRequisitionPort.deleteRequisitionById(id);
    }

    @Override
    public List<Requisition> getAllRequisitions() {
        return getRequisitionPort.getAllRequisitions();
    }

    @Override
    public Requisition getRequisitionById(Long id) {
        return getRequisitionPort.getRequisitionById(id);
    }

    @Override
    public void createCart(Cart cart) {
        Double totalPrice = 0.0;
        for (PurchaseOrderItem purchaseOrderItem : cart.getPurchaseOrderItemList()) {
            totalPrice = totalPrice + purchaseOrderItem.getPrice();
        }
        cart.setTotalPrice(totalPrice);
        savePurchaseOrderPort.createCart(cart);
    }

    @Override
    public Cart getCartById(Long id) {
        return getPurchaseOrderPort.getCartById(id);
    }

    @Override
    public Cart getCartBySiteManagerId(Long id) {
        return getPurchaseOrderPort.getCartBySiteManagerId(id);
    }
}
