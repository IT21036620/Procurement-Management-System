package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Company;

public interface SaveCompanyPort {
    /**
     * Create Company
     * @param company - company
     */
    void createCompany(Company company);

    /**
     * Update company
     * @param company - company
     */
    void updateCompany(Company company);

    /**
     * Delete company
     * @param id - company id
     */

    void deleteCompanyById(Long id);
}
