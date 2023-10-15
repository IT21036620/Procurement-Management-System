package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.AccountingOfficer;
import com.csse.procurement.business.entity.ProcurementOfficer;

import java.util.List;

public interface GetProcurementOfficerPort {
    /**
     * Get all procurement officers
     * @return - List of procurement officers
     */
    List<ProcurementOfficer> getAllProcurementOfficers();

    /**
     * Get procurement officer by id
     * @param id - procurement officer id
     * @return - procurement officer
     */
    ProcurementOfficer getProcurementOfficerById(Long id);
}
