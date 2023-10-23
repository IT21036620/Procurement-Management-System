package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Company;

import java.util.List;

public interface GetCompanyPort {
    /**
     * Get all companies
     * @return - List of companies
     */
    List<Company> getAllCompanies();

    /**
     * Get a company by id
     * @param id - company id
     * @return - company
     */
    Company getCompanyById(Long id);
}
