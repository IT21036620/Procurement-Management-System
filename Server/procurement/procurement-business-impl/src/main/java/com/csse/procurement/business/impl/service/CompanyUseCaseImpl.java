package com.csse.procurement.business.impl.service;

import com.csse.procurement.business.entity.BankAccount;
import com.csse.procurement.business.entity.Company;
import com.csse.procurement.business.entity.Department;
import com.csse.procurement.business.entity.Policy;
import com.csse.procurement.business.port.in.CompanyUseCase;
import com.csse.procurement.business.port.out.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyUseCaseImpl implements CompanyUseCase {
    private static final String COMPANY_NOT_FOUND = "Company not found";
    private static final String DEPARTMENT_NOT_FOUND = "Department not found";
    private static final String POLICY_NOT_FOUND = "Policy not found";
    private static final String BANK_ACCOUNT_NOT_FOUND = "Bank account not found";

    @Autowired
    private SaveCompanyPort saveCompanyPort;
    @Autowired
    private SaveBankAccountPort saveBankAccountPort;
    @Autowired
    private SaveDepartmentPort saveDepartmentPort;
    @Autowired
    private SavePolicyPort savePolicyPort;
    @Autowired
    private GetCompanyPort getCompanyPort;
    @Autowired
    private GetBankAccountPort getBankAccountPort;
    @Autowired
    private GetDepartmentPort getDepartmentPort;
    @Autowired
    private GetPolicyPort getPolicyPort;

    @Override
    public void createCompany(Company company) {

    }

    @Override
    public void updateCompany(Company company) {

    }

    @Override
    public void deleteCompanyById(Long id) {

    }

    @Override
    public List<Company> getAllCompanies() {
        return null;
    }

    @Override
    public Company getCompanyById(Long id) {
        return null;
    }

    @Override
    public void createDepartment(Department department) {

    }

    @Override
    public void updateDepartment(Department department) {

    }

    @Override
    public void deleteDepartmentById(Long id) {

    }

    @Override
    public List<Department> getAllDepartments() {
        return null;
    }

    @Override
    public Department getDepartmentById(Long id) {
        return null;
    }

    @Override
    public void createPolicy(Policy policy) {

    }

    @Override
    public void updatePolicy(Policy policy) {

    }

    @Override
    public void deletePolicyById(Long id) {

    }

    @Override
    public List<Policy> getAllPolicies() {
        return null;
    }

    @Override
    public Policy getPolicyById(Long id) {
        return null;
    }

    @Override
    public void createBankAccount(BankAccount bankAccount) {

    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) {

    }

    @Override
    public void deleteBankAccountById(Long id) {

    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return null;
    }

    @Override
    public BankAccount getBankAccountById(Long id) {
        return null;
    }
}
