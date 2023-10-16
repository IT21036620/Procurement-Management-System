package com.csse.procurement.business.port.in;

import com.csse.hexa.core.UseCase;
import com.csse.procurement.business.entity.Invoice;
import com.csse.procurement.business.entity.Payment;

import java.util.List;

@UseCase
public interface PaymentUseCase {
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

    /**
     * Create invoice
     * @param invoice - invoice
     */
    void createInvoice(Invoice invoice);

    /**
     * Update invoice
     * @param invoice - invoice
     */
    void updateInvoice(Invoice invoice);

    /**
     * Delete invoice
     * @param id - invoice id
     */
    void deleteInvoiceById(Long id);

    /**
     * Get all invoices
     * @return - List of invoices
     */
    List<Invoice> getAllInvoices();

    /**
     * Get an invoice by id
     * @param id - invoice id
     * @return - invoice
     */
    Invoice getInvoiceById(Long id);
}
