package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.BankAccount;

import java.util.List;

public interface GetBankAccountPort {
    /**
     * Get all bank Accounts
     * @return - List of bank Accounts
     */
    List<BankAccount> getAllBankAccounts();

    /**
     * Get bank Account by id
     * @param id - bank Account id
     * @return - bank Account
     */
    BankAccount getBankAccountById(Long id);
}
