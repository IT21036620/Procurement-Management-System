package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.AccountingOfficer;
import com.csse.procurement.business.entity.LineManager;
import com.csse.procurement.business.entity.Policy;

import java.util.List;

public interface GetAccountingOfficerPort {
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
}
