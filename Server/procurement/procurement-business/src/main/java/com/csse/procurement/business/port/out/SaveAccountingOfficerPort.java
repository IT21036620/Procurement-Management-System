package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.AccountingOfficer;

public interface SaveAccountingOfficerPort {
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
}
