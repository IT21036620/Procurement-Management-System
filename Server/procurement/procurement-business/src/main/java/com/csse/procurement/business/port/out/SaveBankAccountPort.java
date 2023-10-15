package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.BankAccount;

public interface SaveBankAccountPort {
    /**
     * Create bank Account
     * @param bankAccount - bank Account
     */
    void createBankAccount(BankAccount bankAccount);

    /**
     * Update bank Account
     * @param bankAccount - bank Account
     */
    void updateBankAccount(BankAccount bankAccount);

    /**
     * Delete bank Account
     * @param id - bank Account id
     */
    void deleteBankAccountById(Long id);
}
