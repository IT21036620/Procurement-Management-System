package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Department;

import java.util.List;

public interface GetDepartmentPort {
    /**
     * Get all departments
     * @return - List of departments
     */
    List<Department> getAllDepartments();

    /**
     * Get department by id
     * @param id - department id
     * @return - department
     */
    Department getDepartmentById(Long id);
}
