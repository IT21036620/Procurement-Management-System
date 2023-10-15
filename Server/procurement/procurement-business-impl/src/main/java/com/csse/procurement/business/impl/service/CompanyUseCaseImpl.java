package com.csse.procurement.business.impl.service;

import com.csse.procurement.business.entity.*;
import com.csse.procurement.business.exception.BusinessLogicException;
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
        saveCompanyPort.createCompany(company);
    }

    @Override
    public void updateCompany(Company company) {
        Company existingCompany = getCompanyPort.getCompanyById(company.getId());

        if (existingCompany == null) {
            throw new BusinessLogicException(COMPANY_NOT_FOUND);
        }

        saveCompanyPort.updateCompany(company);
    }

    @Override
    public void deleteCompanyById(Long id) {
        saveCompanyPort.deleteCompanyById(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return getCompanyPort.getAllCompanies();
    }

    @Override
    public Company getCompanyById(Long id) {
        return getCompanyPort.getCompanyById(id);
    }

    @Override
    public void createDepartment(Department department) {
        saveDepartmentPort.createDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        Department existingDepartment = getDepartmentPort.getDepartmentById(department.getId());

        if (existingDepartment == null) {
            throw new BusinessLogicException(DEPARTMENT_NOT_FOUND);
        }

        saveDepartmentPort.updateDepartment(department);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        saveDepartmentPort.deleteDepartmentById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return getDepartmentPort.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return getDepartmentPort.getDepartmentById(id);
    }

    @Override
    public void createPolicy(Policy policy) {
        savePolicyPort.createPolicy(policy);
    }

    @Override
    public void updatePolicy(Policy policy) {
        Policy existingPolicy = getPolicyPort.getPolicyById(policy.getId());

        if (existingPolicy == null) {
            throw new BusinessLogicException(POLICY_NOT_FOUND);
        }

        savePolicyPort.updatePolicy(policy);
    }

    @Override
    public void deletePolicyById(Long id) {
        savePolicyPort.deletePolicyById(id);
    }

    @Override
    public List<Policy> getAllPolicies() {
        return getPolicyPort.getAllPolicies();
    }

    @Override
    public Policy getPolicyById(Long id) {
        return getPolicyPort.getPolicyById(id);
    }

    @Override
    public void createBankAccount(BankAccount bankAccount) {
        saveBankAccountPort.createBankAccount(bankAccount);
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) {
        BankAccount existingBankAccount = getBankAccountPort.getBankAccountById(bankAccount.getId());

        if (existingBankAccount == null) {
            throw new BusinessLogicException(BANK_ACCOUNT_NOT_FOUND);
        }

        saveBankAccountPort.updateBankAccount(bankAccount);
    }

    @Override
    public void deleteBankAccountById(Long id) {
        saveBankAccountPort.deleteBankAccountById(id);
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return getBankAccountPort.getAllBankAccounts();
    }

    @Override
    public BankAccount getBankAccountById(Long id) {
        return getBankAccountPort.getBankAccountById(id);
    }
}
