package com.csse.procurement.api.procurementapicore.adapter.jpa;

import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.*;
import com.csse.procurement.business.entity.*;
import com.csse.procurement.business.port.out.GetPurchaseOrderPort;
import com.csse.procurement.business.port.out.GetRequisitionPort;
import com.csse.procurement.business.port.out.SavePurchaseOrderPort;
import com.csse.procurement.business.port.out.SaveRequisitionPort;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderPersistentAdapter implements SavePurchaseOrderPort, GetPurchaseOrderPort, SaveRequisitionPort, GetRequisitionPort {
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderItemRepository purchaseOrderItemRepository;
    private final RequisitionRepository requisitionRepository;
    private final SiteManagerRepository siteManagerRepository;
    private final CartRepository cartRepository;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    public OrderPersistentAdapter(PurchaseOrderRepository purchaseOrderRepository, PurchaseOrderItemRepository purchaseOrderItemRepository, RequisitionRepository requisitionRepository, SiteManagerRepository siteManagerRepository, CartRepository cartRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.purchaseOrderItemRepository = purchaseOrderItemRepository;
        this.requisitionRepository = requisitionRepository;
        this.siteManagerRepository = siteManagerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void createPurchaseOrder(PurchaseOrder purchaseOrder) {
        if (purchaseOrder != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder dbPurchaseOrder = mapper.map(purchaseOrder, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder.class);
            dbPurchaseOrder.setStatus(String.valueOf(purchaseOrder.getStatus()));
            purchaseOrderRepository.save(dbPurchaseOrder);
        }
    }

    @Override
    public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
        Long purchaseOrderId = purchaseOrder.getId();

        if (purchaseOrderId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder> optionalPurchaseOrder = purchaseOrderRepository.findById(purchaseOrderId);
        if (optionalPurchaseOrder.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder existingPurchaseOrder = optionalPurchaseOrder.get();
            List<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrderItem> purchaseOrderItemList = new ArrayList<>();

            existingPurchaseOrder.setPoReference(purchaseOrder.getPoReference());
            existingPurchaseOrder.setTotalPrice(purchaseOrder.getTotalPrice());
            existingPurchaseOrder.setStatus(String.valueOf(purchaseOrder.getStatus()));

            if (purchaseOrder.getSiteManager() != null) {
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SiteManager siteManager = siteManagerRepository.findById(purchaseOrder.getSiteManager().getId()).orElse(null);
                existingPurchaseOrder.setSiteManager(siteManager);
            }

            if (purchaseOrder.getPurchaseOrderItemList() != null && !purchaseOrder.getPurchaseOrderItemList().isEmpty()) {
                for (PurchaseOrderItem purchaseOrderItem : purchaseOrder.getPurchaseOrderItemList()) {
                    com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrderItem dbPurchaseOrderItem = mapper.map(purchaseOrderItem, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrderItem.class);
                    purchaseOrderItemList.add(dbPurchaseOrderItem);
                }
            }

            existingPurchaseOrder.setPurchaseOrderItemList(purchaseOrderItemList);
            purchaseOrderRepository.save(existingPurchaseOrder);
        }
    }

    @Override
    public void deletePurchaseOrderById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder> optionalPurchaseOrder = purchaseOrderRepository.findById(id);

        if (optionalPurchaseOrder.isPresent()) {
            purchaseOrderRepository.deleteById(id);
        }
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        List<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder> purchaseOrderList = purchaseOrderRepository.findAll(Sort.sort(com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder.class).by(com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder::getCreatedDate).ascending());
        return purchaseOrderList.stream().map(n-> mapper.map(n, PurchaseOrder.class)).toList();
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder> purchaseOrder = purchaseOrderRepository.findById(id);
        return mapper.map(purchaseOrder, PurchaseOrder.class);
    }

    @Override
    public List<PurchaseOrderItem> getAllPoItemsByPoId(Long id) {
        return purchaseOrderItemRepository.findByPurchaseOrderId(id).stream().map(n-> mapper.map(n, PurchaseOrderItem.class)).toList();
    }

    @Override
    public void createCart(Cart cart) {
        if (cart != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Cart dbCart = mapper.map(cart, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Cart.class);
            cartRepository.save(dbCart);
        }
    }

    @Override
    public Cart getCartById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Cart> optionalCart = cartRepository.findById(id);
        return mapper.map(optionalCart, Cart.class);
    }

    @Override
    public Cart getCartBySiteManagerId(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Cart> optionalCart = cartRepository.getCartBySiteManagerId(id);
        return mapper.map(optionalCart, Cart.class);
    }

    @Override
    public void createRequisition(Requisition requisition) {
        if (requisition != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Requisition dbRequisition = mapper.map(requisition, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Requisition.class);
            dbRequisition.setStatus(String.valueOf(requisition.getStatus()));
            requisitionRepository.save(dbRequisition);
        }
    }

    @Override
    public void updateRequisition(Requisition requisition) {
        Long requisitionId = requisition.getId();

        if (requisitionId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Requisition> optionalRequisition = requisitionRepository.findById(requisitionId);
        if (optionalRequisition.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Requisition existingRequisition = optionalRequisition.get();

            existingRequisition.setReqOrdNo(requisition.getReqOrdNo());
            existingRequisition.setDetails(requisition.getDetails());
            existingRequisition.setStatus(String.valueOf(requisition.getStatus()));
            existingRequisition.setAmount(requisition.getAmount());

            requisitionRepository.save(existingRequisition);
        }
    }

    @Override
    public void deleteRequisitionById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Requisition> optionalRequisition = requisitionRepository.findById(id);

        if (optionalRequisition.isPresent()) {
            requisitionRepository.deleteById(id);
        }
    }

    @Override
    public List<Requisition> getAllRequisitions() {
        return requisitionRepository.findAll().stream().map(n->mapper.map(n, Requisition.class)).toList();
    }

    @Override
    public Requisition getRequisitionById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Requisition> requisition = requisitionRepository.findById(id);
        return mapper.map(requisition, Requisition.class);
    }
}
