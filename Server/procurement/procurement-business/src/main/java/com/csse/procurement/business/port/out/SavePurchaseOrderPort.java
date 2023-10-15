package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Policy;
import com.csse.procurement.business.entity.PurchaseOrder;

public interface SavePurchaseOrderPort {
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
}
