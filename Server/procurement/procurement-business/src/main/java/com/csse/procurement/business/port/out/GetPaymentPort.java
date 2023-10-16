package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Payment;

import java.util.List;

public interface GetPaymentPort {
    /**
     * Get all payments
     * @return - List of payments
     */
    List<Payment> getAllPayments();

    /**
     * Get a payment by id
     * @param id - payment id
     * @return - payment
     */
    Payment getPaymentById(Long id);
}
