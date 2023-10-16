package com.csse.procurement.business.impl.service;

import com.csse.procurement.business.entity.Invoice;
import com.csse.procurement.business.entity.Payment;
import com.csse.procurement.business.exception.BusinessLogicException;
import com.csse.procurement.business.port.in.PaymentUseCase;
import com.csse.procurement.business.port.out.GetInvoicePort;
import com.csse.procurement.business.port.out.GetPaymentPort;
import com.csse.procurement.business.port.out.SaveInvoicePort;
import com.csse.procurement.business.port.out.SavePaymentPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentUseCaseImpl implements PaymentUseCase {
    private static final String PAYMENT_NOT_FOUND = "Payment not found";
    private static final String INVOICE_NOT_FOUND = "Invoice not found";

    @Autowired
    private SavePaymentPort savePaymentPort;
    @Autowired
    private GetPaymentPort getPaymentPort;
    @Autowired
    private SaveInvoicePort saveInvoicePort;
    @Autowired
    private GetInvoicePort getInvoicePort;

    @Override
    public void createPayment(Payment payment) {
        savePaymentPort.createPayment(payment);
    }

    @Override
    public void updatePayment(Payment payment) {
        Payment existingPayment = getPaymentPort.getPaymentById(payment.getId());

        if (existingPayment == null) {
            throw new BusinessLogicException(PAYMENT_NOT_FOUND);
        }

        savePaymentPort.updatePayment(payment);
    }

    @Override
    public void deletePaymentById(Long id) {
        savePaymentPort.deletePaymentById(id);
    }

    @Override
    public List<Payment> getAllPayments() {
        return getPaymentPort.getAllPayments();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return getPaymentPort.getPaymentById(id);
    }

    @Override
    public void createInvoice(Invoice invoice) {
        saveInvoicePort.createInvoice(invoice);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        Invoice existingInvoice = getInvoicePort.getInvoiceById(invoice.getId());

        if (existingInvoice == null) {
            throw new BusinessLogicException(INVOICE_NOT_FOUND);
        }

        saveInvoicePort.updateInvoice(invoice);
    }

    @Override
    public void deleteInvoiceById(Long id) {
        saveInvoicePort.deleteInvoiceById(id);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return getInvoicePort.getAllInvoices();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        return getInvoicePort.getInvoiceById(id);
    }
}
