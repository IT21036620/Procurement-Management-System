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
        if (department != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department dbDepartment = mapper.map(department, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department.class);
            departmentRepository.save(dbDepartment);
        }
    }

    @Override
    public void updateDepartment(Department department) {
        Long departmentId = department.getId();

        if (departmentId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department existingDepartment = optionalDepartment.get();

            existingDepartment.setDepartmentName(department.getDepartmentName());
            departmentRepository.save(existingDepartment);
        }
    }

    @Override
    public void deleteDepartmentById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department> optionalDepartment = departmentRepository.findById(id);

        if (optionalDepartment.isPresent()) {
            departmentRepository.deleteById(id);
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll().stream().map(n->mapper.map(n, Department.class)).toList();
    }

    @Override
    public Department getDepartmentById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department> department = departmentRepository.findById(id);
        return mapper.map(department, Department.class);
    }

    @Override
    public void createPolicy(Policy policy) {
        if (policy != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Policy dbPolicy = mapper.map(policy, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Policy.class);
            policyRepository.save(dbPolicy);
        }
    }

    @Override
    public void updatePolicy(Policy policy) {
        Long policyId = policy.getId();

        if (policyId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Policy> optionalPolicy = policyRepository.findById(policyId);
        if (optionalPolicy.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Policy existingPolicy = optionalPolicy.get();
            LineManager lineManager = lineManagerRepository.findById(policy.getMadeBy().getId()).orElse(null);

            existingPolicy.setPolicyNo(policy.getPolicyNo());
            existingPolicy.setStatements(policy.getStatements());
            existingPolicy.setMadeBy(lineManager);
            policyRepository.save(existingPolicy);
        }
    }

    @Override
    public void deletePolicyById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Policy> optionalPolicy = policyRepository.findById(id);

        if (optionalPolicy.isPresent()) {
            policyRepository.deleteById(id);
        }
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll().stream().map(n->mapper.map(n, Policy.class)).toList();
    }

    @Override
    public Policy getPolicyById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Policy> policy = policyRepository.findById(id);
        return mapper.map(policy, Policy.class);
    }

    @Override
    public void createBankAccount(BankAccount bankAccount) {
        if (bankAccount != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.BankAccount dbBankAccount = mapper.map(bankAccount, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.BankAccount.class);
            bankAccountRepository.save(dbBankAccount);
        }
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) {
        Long bankAccountId = bankAccount.getId();

        if (bankAccountId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.BankAccount> optionalBankAccount = bankAccountRepository.findById(bankAccountId);
        if (optionalBankAccount.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.BankAccount existingBankAccount = optionalBankAccount.get();

            existingBankAccount.setAccountNo(bankAccount.getAccountNo());
            existingBankAccount.setAccountName(bankAccount.getAccountName());
            existingBankAccount.setAccountType(bankAccount.getAccountType());
            existingBankAccount.setBranch(bankAccount.getBranch());
            bankAccountRepository.save(existingBankAccount);
        }
    }

    @Override
    public void deleteBankAccountById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.BankAccount> optionalBankAccount = bankAccountRepository.findById(id);

        if (optionalBankAccount.isPresent()) {
            bankAccountRepository.deleteById(id);
        }
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll().stream().map(n->mapper.map(n, BankAccount.class)).toList();
    }

    @Override
    public BankAccount getBankAccountById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.BankAccount> bankAccount = bankAccountRepository.findById(id);
        return mapper.map(bankAccount, BankAccount.class);
    }
}
