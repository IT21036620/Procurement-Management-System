package com.csse.procurement.business.port.in;

import com.csse.hexa.core.UseCase;
import com.csse.procurement.business.entity.*;

import java.util.List;

@UseCase
public interface CompanyUseCase {
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

    /**
     * Create policy
     * @param policy - policy
     */
    void createPolicy(Policy policy);

    /**
     * Update policy
     * @param policy - policy
     */
    void updatePolicy(Policy policy);

    /**
     * Delete policy
     * @param id - policy id
     */
    void deletePolicyById(Long id);

    /**
     * Get all policies
     * @return - List of policies
     */
    List<Policy> getAllPolicies();

    /**
     * Get policy by id
     * @param id - policy id
     * @return - policy
     */
    Policy getPolicyById(Long id);

    /**
     * Create bank Account
     * @param bankAccount - bank Account
     */
    void createBankAccount(BankAccount bankAccount);

    /**
     * Update bank Account
     * @param bankAccount - bank Account
     */
    void updateBankAccount(BankAccount bankAccount);

    /**
     * Delete bank Account
     * @param id - bank Account id
     */
    void deleteBankAccountById(Long id);

    /**
     * Get all bank Accounts
     * @return - List of bank Accounts
     */
    List<BankAccount> getAllBankAccounts();

    /**
     * Get bank Account by id
     * @param id - bank Account id
     * @return - bank Account
     */
    BankAccount getBankAccountById(Long id);
}
