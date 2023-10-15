package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.PurchaseOrder;
import com.csse.procurement.business.entity.PurchaseOrderItem;
import com.csse.procurement.business.entity.Requisition;

import java.util.List;

public interface GetPurchaseOrderPort {
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
     * Get all purchase order items by purchase order id
     * @param id - purchase order id
     * @return - List of purchase order items
     */
    List<PurchaseOrderItem> getAllPoItemsByPoId(Long id);
}
