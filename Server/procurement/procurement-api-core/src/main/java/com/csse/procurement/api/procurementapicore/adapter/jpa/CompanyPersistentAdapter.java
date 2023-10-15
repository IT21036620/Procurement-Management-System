package com.csse.procurement.api.procurementapicore.adapter.jpa;

import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.*;
import com.csse.procurement.business.entity.BankAccount;
import com.csse.procurement.business.entity.Company;
import com.csse.procurement.business.entity.Department;
import com.csse.procurement.business.entity.Policy;
import com.csse.procurement.business.port.out.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyPersistentAdapter implements SaveCompanyPort, GetCompanyPort, SaveDepartmentPort, GetDepartmentPort, SavePolicyPort, GetPolicyPort, SaveBankAccountPort, GetBankAccountPort {
    private final BankAccountRepository bankAccountRepository;
    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final LineManagerRepository lineManagerRepository;
    private final PolicyRepository policyRepository;
    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    public CompanyPersistentAdapter(BankAccountRepository bankAccountRepository, CompanyRepository companyRepository, DepartmentRepository departmentRepository, LineManagerRepository lineManagerRepository, PolicyRepository policyRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.companyRepository = companyRepository;
        this.departmentRepository = departmentRepository;
        this.lineManagerRepository = lineManagerRepository;
        this.policyRepository = policyRepository;
    }

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
