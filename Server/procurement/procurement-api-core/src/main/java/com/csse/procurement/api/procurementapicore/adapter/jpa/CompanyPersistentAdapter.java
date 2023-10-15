package com.csse.procurement.api.procurementapicore.adapter.jpa;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.LineManager;
import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SiteManager;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.*;
import com.csse.procurement.business.entity.*;
import com.csse.procurement.business.port.out.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if (company != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company dbCompany = mapper.map(company, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company.class);
            companyRepository.save(dbCompany);
        }
    }

    @Override
    public void updateCompany(Company company) {
        Long companyId = company.getId();

        if (companyId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company> optionalCompany = companyRepository.findById(companyId);
        if (optionalCompany.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company existingCompany = optionalCompany.get();
            List<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Policy> policyList = new ArrayList<>();
            List<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department> departmentList = new ArrayList<>();
            List<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.BankAccount> bankAccountList = new ArrayList<>();

            existingCompany.setCompanyName(company.getCompanyName());
            existingCompany.setHoAddress(company.getHoAddress());
            existingCompany.setContactNo(company.getContactNo());
            existingCompany.setEmail(company.getEmail());

            if (company.getPolicyList() != null && !company.getPolicyList().isEmpty()) {
                for (Policy policy : company.getPolicyList()) {
                    com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Policy dbPolicy = mapper.map(policy, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Policy.class);
                    policyList.add(dbPolicy);
                }
            }

            if (company.getDepartmentList() != null && !company.getDepartmentList().isEmpty()) {
                for (Department department : company.getDepartmentList()) {
                    com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department dbDepartment = mapper.map(department, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department.class);
                    departmentList.add(dbDepartment);
                }
            }

            if (company.getBankAccountList() != null && !company.getBankAccountList().isEmpty()) {
                for (BankAccount bankAccount : company.getBankAccountList()) {
                    com.csse.procurement.api.procurementapicore.adapter.jpa.entity.BankAccount dbBankAccount = mapper.map(bankAccount, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.BankAccount.class);
                    bankAccountList.add(dbBankAccount);
                }
            }

            existingCompany.setPolicyList(policyList);
            existingCompany.setDepartmentList(departmentList);
            existingCompany.setBankAccountList(bankAccountList);
            companyRepository.save(existingCompany);
        }
    }

    @Override
    public void deleteCompanyById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company> optionalCompany = companyRepository.findById(id);

        if (optionalCompany.isPresent()) {
            companyRepository.deleteById(id);
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll().stream().map(n->mapper.map(n, Company.class)).toList();
    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company> company = companyRepository.findById(id);
        return mapper.map(company, Company.class);
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
