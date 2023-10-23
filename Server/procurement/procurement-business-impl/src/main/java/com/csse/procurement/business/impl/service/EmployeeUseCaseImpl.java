package com.csse.procurement.business.impl.service;

import com.csse.procurement.business.entity.*;
import com.csse.procurement.business.exception.BusinessLogicException;
import com.csse.procurement.business.port.in.EmployeeUseCase;
import com.csse.procurement.business.port.out.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeUseCaseImpl implements EmployeeUseCase {
    private static final String LINE_MANAGER_NOT_FOUND = "Line manager not found";
    private static final String SYSTEM_ADMIN_NOT_FOUND = "System admin not found";
    private static final String ACCOUNTING_OFFICER_NOT_FOUND = "Accounting officer not found";
    private static final String PROCUREMENT_OFFICER_NOT_FOUND = "Procurement officer not found";

    @Autowired
    private SaveLineManagerPort saveLineManagerPort;
    @Autowired
    private GetLineManagerPort getLineManagerPort;
    @Autowired
    private SaveSystemAdminPort saveSystemAdminPort;
    @Autowired
    private GetSystemAdminPort getSystemAdminPort;
    @Autowired
    private SaveAccountingOfficerPort saveAccountingOfficerPort;
    @Autowired
    private GetAccountingOfficerPort getAccountingOfficerPort;
    @Autowired
    private SaveProcurementOfficerPort saveProcurementOfficerPort;
    @Autowired
    private GetProcurementOfficerPort getProcurementOfficerPort;

    @Override
    public void createLineManager(LineManager lineManager) {
        saveLineManagerPort.createLineManager(lineManager);
    }

    @Override
    public void updateLineManager(LineManager lineManager) {
        LineManager existingLineManager = getLineManagerPort.getLineManagerById(lineManager.getId());

        if (existingLineManager == null) {
            throw new BusinessLogicException(LINE_MANAGER_NOT_FOUND);
        }

        saveLineManagerPort.updateLineManager(lineManager);
    }

    @Override
    public void deleteLineManagerById(Long id) {
        saveLineManagerPort.deleteLineManagerById(id);
    }

    @Override
    public List<LineManager> getAllLineManagers() {
        return getLineManagerPort.getAllLineManagers();
    }

    @Override
    public LineManager getLineManagerById(Long id) {
        return getLineManagerPort.getLineManagerById(id);
    }

    @Override
    public void createSystemAdmin(SystemAdmin systemAdmin) {
        saveSystemAdminPort.createSystemAdmin(systemAdmin);
    }

    @Override
    public void updateSystemAdmin(SystemAdmin systemAdmin) {
        SystemAdmin existingSystemAdmin = getSystemAdminPort.getSystemAdminById(systemAdmin.getId());

        if (existingSystemAdmin == null) {
            throw new BusinessLogicException(SYSTEM_ADMIN_NOT_FOUND);
        }

        saveSystemAdminPort.updateSystemAdmin(systemAdmin);
    }

    @Override
    public void deleteSystemAdminById(Long id) {
        saveSystemAdminPort.deleteSystemAdminById(id);
    }

    @Override
    public List<SystemAdmin> getAllSystemAdmins() {
        return getSystemAdminPort.getAllSystemAdmins();
    }

    @Override
    public SystemAdmin getSystemAdminById(Long id) {
        return getSystemAdminPort.getSystemAdminById(id);
    }

    @Override
    public void createAccountingOfficer(AccountingOfficer accountingOfficer) {
        saveAccountingOfficerPort.createAccountingOfficer(accountingOfficer);
    }

    @Override
    public void updateAccountingOfficer(AccountingOfficer accountingOfficer) {
        AccountingOfficer existingAccountingOfficer = getAccountingOfficerPort.getAccountingOfficerById(accountingOfficer.getId());

        if (existingAccountingOfficer == null) {
            throw new BusinessLogicException(ACCOUNTING_OFFICER_NOT_FOUND);
        }

        saveAccountingOfficerPort.updateAccountingOfficer(accountingOfficer);
    }

    @Override
    public void deleteAccountingOfficerById(Long id) {
        saveAccountingOfficerPort.deleteAccountingOfficerById(id);
    }

    @Override
    public List<AccountingOfficer> getAllAccountingOfficers() {
        return getAccountingOfficerPort.getAllAccountingOfficers();
    }

    @Override
    public AccountingOfficer getAccountingOfficerById(Long id) {
        return getAccountingOfficerPort.getAccountingOfficerById(id);
    }

    @Override
    public void createProcurementOfficer(ProcurementOfficer procurementOfficer) {
        saveProcurementOfficerPort.createProcurementOfficer(procurementOfficer);
    }

    @Override
    public void updateProcurementOfficer(ProcurementOfficer procurementOfficer) {
        ProcurementOfficer existingProcurementOfficer = getProcurementOfficerPort.getProcurementOfficerById(procurementOfficer.getId());

        if (existingProcurementOfficer == null) {
            throw new BusinessLogicException(PROCUREMENT_OFFICER_NOT_FOUND);
        }

        saveProcurementOfficerPort.updateProcurementOfficer(procurementOfficer);
    }

    @Override
    public void deleteProcurementOfficerById(Long id) {
        saveProcurementOfficerPort.deleteProcurementOfficerById(id);
    }

    @Override
    public List<ProcurementOfficer> getAllProcurementOfficers() {
        return getProcurementOfficerPort.getAllProcurementOfficers();
    }

    @Override
    public ProcurementOfficer getProcurementOfficerById(Long id) {
        return getProcurementOfficerPort.getProcurementOfficerById(id);
    }
}
