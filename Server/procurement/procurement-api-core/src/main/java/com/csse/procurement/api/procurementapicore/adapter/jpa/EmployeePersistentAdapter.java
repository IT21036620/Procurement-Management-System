package com.csse.procurement.api.procurementapicore.adapter.jpa;

import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.*;
import com.csse.procurement.business.entity.*;
import com.csse.procurement.business.port.out.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeePersistentAdapter implements SaveLineManagerPort, GetLineManagerPort, SaveSystemAdminPort, GetSystemAdminPort, SaveAccountingOfficerPort, GetAccountingOfficerPort, SaveProcurementOfficerPort, GetProcurementOfficerPort {
    private final LineManagerRepository lineManagerRepository;
    private final AccountingOfficerRepository accountingOfficerRepository;
    private final ProcurementOfficerRepository procurementOfficerRepository;
    private final SystemAdminRepository systemAdminRepository;
    private final DepartmentRepository departmentRepository;
    private final CompanyRepository companyRepository;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    public EmployeePersistentAdapter(LineManagerRepository lineManagerRepository, AccountingOfficerRepository accountingOfficerRepository, ProcurementOfficerRepository procurementOfficerRepository, SystemAdminRepository systemAdminRepository, DepartmentRepository departmentRepository, CompanyRepository companyRepository) {
        this.lineManagerRepository = lineManagerRepository;
        this.accountingOfficerRepository = accountingOfficerRepository;
        this.procurementOfficerRepository = procurementOfficerRepository;
        this.systemAdminRepository = systemAdminRepository;
        this.departmentRepository = departmentRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<LineManager> getAllLineManagers() {
        return lineManagerRepository.findAll().stream().map(n->mapper.map(n, LineManager.class)).toList();
    }

    @Override
    public LineManager getLineManagerById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.LineManager> lineManager = lineManagerRepository.findById(id);
        return mapper.map(lineManager, LineManager.class);
    }

    @Override
    public void createLineManager(LineManager lineManager) {
        if (lineManager != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.LineManager dbLineManager = mapper.map(lineManager, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.LineManager.class);
            lineManagerRepository.save(dbLineManager);
        }
    }

    @Override
    public void updateLineManager(LineManager lineManager) {
        Long lineManagerId = lineManager.getId();

        if (lineManagerId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.LineManager> optionalLineManager = lineManagerRepository.findById(lineManagerId);
        if (optionalLineManager.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.LineManager existingLineManager = optionalLineManager.get();

            existingLineManager.setUserName(lineManager.getUserName());
            existingLineManager.setPassword(lineManager.getPassword());
            existingLineManager.setEmail(lineManager.getEmail());
            existingLineManager.setContactNo(lineManager.getContactNo());
            existingLineManager.setEmployeeCode(lineManager.getEmployeeCode());
            existingLineManager.setRole(lineManager.getRole());
            existingLineManager.setManagementCode(lineManager.getManagementCode());
            existingLineManager.setAuthorizedStatus(lineManager.getAuthorizedStatus());

            if (lineManager.getDepartment() != null) {
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department department = departmentRepository.findById(lineManager.getDepartment().getId()).orElse(null);
                existingLineManager.setDepartment(department);
            }

            if (lineManager.getCompany() != null) {
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company company = companyRepository.findById(lineManager.getCompany().getId()).orElse(null);
                existingLineManager.setCompany(company);
            }

            lineManagerRepository.save(existingLineManager);
        }
    }

    @Override
    public void deleteLineManagerById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.LineManager> optionalLineManager = lineManagerRepository.findById(id);

        if (optionalLineManager.isPresent()) {
            lineManagerRepository.deleteById(id);
        }
    }

    @Override
    public void createSystemAdmin(SystemAdmin systemAdmin) {
        if (systemAdmin != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SystemAdmin dbSystemAdmin = mapper.map(systemAdmin, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SystemAdmin.class);
            systemAdminRepository.save(dbSystemAdmin);
        }
    }

    @Override
    public void updateSystemAdmin(SystemAdmin systemAdmin) {
        Long systemAdminId = systemAdmin.getId();

        if (systemAdminId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SystemAdmin> optionalSystemAdmin = systemAdminRepository.findById(systemAdminId);
        if (optionalSystemAdmin.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SystemAdmin existingSystemAdmin = optionalSystemAdmin.get();

            existingSystemAdmin.setUserName(systemAdmin.getUserName());
            existingSystemAdmin.setPassword(systemAdmin.getPassword());
            existingSystemAdmin.setEmail(systemAdmin.getEmail());
            existingSystemAdmin.setContactNo(systemAdmin.getContactNo());
            existingSystemAdmin.setEmployeeCode(systemAdmin.getEmployeeCode());
            existingSystemAdmin.setRole(systemAdmin.getRole());
            existingSystemAdmin.setAuthorizedStatus(systemAdmin.getAuthorizedStatus());

            if (systemAdmin.getCompany() != null) {
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company company = companyRepository.findById(systemAdmin.getCompany().getId()).orElse(null);
                existingSystemAdmin.setCompany(company);
            }

            systemAdminRepository.save(existingSystemAdmin);
        }
    }

    @Override
    public void deleteSystemAdminById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SystemAdmin> optionalSystemAdmin = systemAdminRepository.findById(id);

        if (optionalSystemAdmin.isPresent()) {
            systemAdminRepository.deleteById(id);
        }
    }

    @Override
    public List<SystemAdmin> getAllSystemAdmins() {
        return systemAdminRepository.findAll().stream().map(n->mapper.map(n, SystemAdmin.class)).toList();
    }

    @Override
    public SystemAdmin getSystemAdminById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SystemAdmin> systemAdmin = systemAdminRepository.findById(id);
        return mapper.map(systemAdmin, SystemAdmin.class);
    }

    @Override
    public void createAccountingOfficer(AccountingOfficer accountingOfficer) {
        if (accountingOfficer != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.AccountingOfficer dbAccountingOfficer = mapper.map(accountingOfficer, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.AccountingOfficer.class);
            accountingOfficerRepository.save(dbAccountingOfficer);
        }
    }

    @Override
    public void updateAccountingOfficer(AccountingOfficer accountingOfficer) {
        Long accountingOfficerId = accountingOfficer.getId();

        if (accountingOfficerId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.AccountingOfficer> optionalAccountingOfficer = accountingOfficerRepository.findById(accountingOfficerId);
        if (optionalAccountingOfficer.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.AccountingOfficer existingAccountingOfficer = optionalAccountingOfficer.get();

            existingAccountingOfficer.setUserName(accountingOfficer.getUserName());
            existingAccountingOfficer.setPassword(accountingOfficer.getPassword());
            existingAccountingOfficer.setEmail(accountingOfficer.getEmail());
            existingAccountingOfficer.setContactNo(accountingOfficer.getContactNo());
            existingAccountingOfficer.setEmployeeCode(accountingOfficer.getEmployeeCode());
            existingAccountingOfficer.setRole(accountingOfficer.getRole());
            existingAccountingOfficer.setAuthorizedStatus(accountingOfficer.getAuthorizedStatus());

            if (accountingOfficer.getDepartment() != null) {
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department department = departmentRepository.findById(accountingOfficer.getDepartment().getId()).orElse(null);
                existingAccountingOfficer.setDepartment(department);
            }

            if (accountingOfficer.getCompany() != null) {
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company company = companyRepository.findById(accountingOfficer.getCompany().getId()).orElse(null);
                existingAccountingOfficer.setCompany(company);
            }

            accountingOfficerRepository.save(existingAccountingOfficer);
        }
    }

    @Override
    public void deleteAccountingOfficerById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.AccountingOfficer> optionalAccountingOfficer = accountingOfficerRepository.findById(id);

        if (optionalAccountingOfficer.isPresent()) {
            accountingOfficerRepository.deleteById(id);
        }
    }

    @Override
    public List<AccountingOfficer> getAllAccountingOfficers() {
        return accountingOfficerRepository.findAll().stream().map(n->mapper.map(n, AccountingOfficer.class)).toList();
    }

    @Override
    public AccountingOfficer getAccountingOfficerById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.AccountingOfficer> accountingOfficer = accountingOfficerRepository.findById(id);
        return mapper.map(accountingOfficer, AccountingOfficer.class);
    }

    @Override
    public void createProcurementOfficer(ProcurementOfficer procurementOfficer) {
        if (procurementOfficer != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.ProcurementOfficer dbProcurementOfficer = mapper.map(procurementOfficer, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.ProcurementOfficer.class);
            procurementOfficerRepository.save(dbProcurementOfficer);
        }
    }

    @Override
    public void updateProcurementOfficer(ProcurementOfficer procurementOfficer) {
        Long procurementOfficerId = procurementOfficer.getId();

        if (procurementOfficerId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.ProcurementOfficer> optionalProcurementOfficer = procurementOfficerRepository.findById(procurementOfficerId);
        if (optionalProcurementOfficer.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.ProcurementOfficer existingProcurementOfficer = optionalProcurementOfficer.get();

            existingProcurementOfficer.setUserName(procurementOfficer.getUserName());
            existingProcurementOfficer.setPassword(procurementOfficer.getPassword());
            existingProcurementOfficer.setEmail(procurementOfficer.getEmail());
            existingProcurementOfficer.setContactNo(procurementOfficer.getContactNo());
            existingProcurementOfficer.setEmployeeCode(procurementOfficer.getEmployeeCode());
            existingProcurementOfficer.setRole(procurementOfficer.getRole());
            existingProcurementOfficer.setAuthorizedStatus(procurementOfficer.getAuthorizedStatus());

            if (procurementOfficer.getDepartment() != null) {
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Department department = departmentRepository.findById(procurementOfficer.getDepartment().getId()).orElse(null);
                existingProcurementOfficer.setDepartment(department);
            }

            if (procurementOfficer.getCompany() != null) {
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company company = companyRepository.findById(procurementOfficer.getCompany().getId()).orElse(null);
                existingProcurementOfficer.setCompany(company);
            }

            procurementOfficerRepository.save(existingProcurementOfficer);
        }
    }

    @Override
    public void deleteProcurementOfficerById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.ProcurementOfficer> optionalProcurementOfficer = procurementOfficerRepository.findById(id);

        if (optionalProcurementOfficer.isPresent()) {
            procurementOfficerRepository.deleteById(id);
        }
    }

    @Override
    public List<ProcurementOfficer> getAllProcurementOfficers() {
        return procurementOfficerRepository.findAll().stream().map(n->mapper.map(n, ProcurementOfficer.class)).toList();
    }

    @Override
    public ProcurementOfficer getProcurementOfficerById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.ProcurementOfficer> procurementOfficer = procurementOfficerRepository.findById(id);
        return mapper.map(procurementOfficer, ProcurementOfficer.class);
    }
}
