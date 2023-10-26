package com.csse.procurement.business.port.in;

import com.csse.hexa.core.UseCase;
import com.csse.procurement.business.entity.Cart;
import com.csse.procurement.business.entity.PurchaseOrder;
import com.csse.procurement.business.entity.Requisition;

import java.util.List;

@UseCase
public interface OrderUseCase {
    /**
     * Create purchase order
     * @param purchaseOrder - purchase order
     */
    void createPurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * Update purchase order
     * @param purchaseOrder - purchase order
     */
    void updatePurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * Delete purchase order
     * @param id - purchase order id
     */
    void deletePurchaseOrderById(Long id);

    /**
     * Get all purchase orders
     * @return - List of purchase orders
     */
    List<PurchaseOrder> getAllPurchaseOrders();

    /**
     * Get a purchase order by id
     * @param id - purchase order id
     * @return - purchase order
     */
    PurchaseOrder getPurchaseOrderById(Long id);

    /**
     * Create requisition
     * @param requisition - requisition
     */
    void createRequisition(Requisition requisition);

    /**
     * Update requisition
     * @param requisition - requisition
     */
    void updateRequisition(Requisition requisition);

    /**
     * Delete requisition
     * @param id - requisition id
     */
    void deleteRequisitionById(Long id);

    /**
     * Get all requisitions
     * @return - List of requisitions
     */
    List<Requisition> getAllRequisitions();

    /**
     * Get a requisition by id
     * @param id - requisition id
     * @return - requisition
     */
    Requisition getRequisitionById(Long id);

    void createCart(Cart cart);

    Cart getCartById(Long id);

    Cart getCartBySiteManagerId(Long id);
}
