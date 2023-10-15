package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Requisition;
import com.csse.procurement.business.entity.Site;

import java.util.List;

public interface GetRequisitionPort {
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
}
