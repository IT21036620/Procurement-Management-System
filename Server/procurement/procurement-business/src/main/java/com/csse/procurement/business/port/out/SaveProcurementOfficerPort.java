package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.ProcurementOfficer;

public interface SaveProcurementOfficerPort {
    /**
     * Create procurement officer
     * @param procurementOfficer - procurement officer
     */
    void createProcurementOfficer(ProcurementOfficer procurementOfficer);

    /**
     * Update procurement officer
     * @param procurementOfficer - procurement officer
     */
    void updateProcurementOfficer(ProcurementOfficer procurementOfficer);

    /**
     * Delete procurement officer
     * @param id - procurement officer id
     */
    void deleteProcurementOfficerById(Long id);
}
