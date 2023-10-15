package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.ProcurementOfficer;
import com.csse.procurement.business.entity.SystemAdmin;

import java.util.List;

public interface GetSystemAdminPort {
    /**
     * Get all system admins
     * @return - List of system admins
     */
    List<SystemAdmin> getAllSystemAdmins();

    /**
     * Get system admin by id
     * @param id - system admin id
     * @return - system admin
     */
    SystemAdmin getSystemAdminById(Long id);
}
