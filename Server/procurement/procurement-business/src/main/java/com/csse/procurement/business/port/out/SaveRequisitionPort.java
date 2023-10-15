package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.PurchaseOrder;
import com.csse.procurement.business.entity.Requisition;

public interface SaveRequisitionPort {
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
}
