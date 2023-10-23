package com.csse.procurement.business.port.in;

import com.csse.hexa.core.UseCase;
import com.csse.procurement.business.entity.*;

import java.util.List;

@UseCase
public interface EmployeeUseCase {
    /**
     * Create line manager
     * @param lineManager - line manager
     */
    void createLineManager(LineManager lineManager);

    /**
     * Update line manager
     * @param lineManager - line manager
     */
    void updateLineManager(LineManager lineManager);

    /**
     * Delete line manager
     * @param id - line manager id
     */
    void deleteLineManagerById(Long id);

    /**
     * Get all line managers
     * @return - List of line managers
     */
    List<LineManager> getAllLineManagers();

    /**
     * Get line manager by id
     * @param id - line manager id
     * @return - line manager
     */
    LineManager getLineManagerById(Long id);

    /**
     * Create system admin
     * @param systemAdmin - system admin
     */
    void createSystemAdmin(SystemAdmin systemAdmin);

    /**
     * Update system admin
     * @param systemAdmin - system admin
     */
    void updateSystemAdmin(SystemAdmin systemAdmin);

    /**
     * Delete system admin
     * @param id - system admin id
     */
    void deleteSystemAdminById(Long id);

    /**
     * Get all system admins
     * @return - List of system admins
     */
    List<SystemAdmin> getAllSystemAdmins();

    /**
     * Get system admin by id
     * @param id - system admin id
     * @return - system admin
     */
    SystemAdmin getSystemAdminById(Long id);

    /**
     * Create accounting officer
     * @param accountingOfficer - accounting officer
     */
    void createAccountingOfficer(AccountingOfficer accountingOfficer);

    /**
     * Update accounting officer
     * @param accountingOfficer - accounting officer
     */
    void updateAccountingOfficer(AccountingOfficer accountingOfficer);

    /**
     * Delete accounting officer
     * @param id - accounting officer id
     */
    void deleteAccountingOfficerById(Long id);

    /**
     * Get all accounting officers
     * @return - List of accounting officers
     */
    List<AccountingOfficer> getAllAccountingOfficers();

    /**
     * Get accounting officer by id
     * @param id - accounting officer id
     * @return - accounting officer
     */
    AccountingOfficer getAccountingOfficerById(Long id);

    /**
     * Create procurement officer
     * @param procurementOfficer - procurement officer
     */
    void createProcurementOfficer(ProcurementOfficer procurementOfficer);

    /**
     * Update procurement officer
     * @param procurementOfficer - procurement officer
     */
    void updateProcurementOfficer(ProcurementOfficer procurementOfficer);

    /**
     * Delete procurement officer
     * @param id - procurement officer id
     */
    void deleteProcurementOfficerById(Long id);

    /**
     * Get all procurement officers
     * @return - List of procurement officers
     */
    List<ProcurementOfficer> getAllProcurementOfficers();

    /**
     * Get procurement officer by id
     * @param id - procurement officer id
     * @return - procurement officer
     */
    ProcurementOfficer getProcurementOfficerById(Long id);
}
