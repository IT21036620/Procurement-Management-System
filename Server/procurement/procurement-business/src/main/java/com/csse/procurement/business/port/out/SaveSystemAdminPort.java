package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.LineManager;
import com.csse.procurement.business.entity.ProcurementOfficer;
import com.csse.procurement.business.entity.SystemAdmin;

public interface SaveSystemAdminPort {
    /**
     * Create system admin
     * @param systemAdmin - system admin
     */
    void createSystemAdmin(SystemAdmin systemAdmin);

    /**
     * Update system admin
     * @param systemAdmin - system admin
     */
    void updateSystemAdmin(SystemAdmin systemAdmin);

    /**
     * Delete system admin
     * @param id - system admin id
     */
    void deleteSystemAdminById(Long id);
}
