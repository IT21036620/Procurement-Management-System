package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Item;
import com.csse.procurement.business.entity.Payment;

public interface SavePaymentPort {
    /**
     * Create payment
     * @param payment - payment
     */
    void createPayment(Payment payment);

    /**
     * Update payment
     * @param payment - payment
     */
    void updatePayment(Payment payment);

    /**
     * Delete payment
     * @param id - payment id
     */
    void deletePaymentById(Long id);
}
