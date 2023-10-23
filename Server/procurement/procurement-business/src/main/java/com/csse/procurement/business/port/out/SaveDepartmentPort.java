package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Department;

public interface SaveDepartmentPort {
    /**
     * Create department
     * @param department - department
     */
    void createDepartment(Department department);

    /**
     * Update department
     * @param department - department
     */
    void updateDepartment(Department department);

    /**
     * Delete department
     * @param id - department id
     */
    void deleteDepartmentById(Long id);
}
