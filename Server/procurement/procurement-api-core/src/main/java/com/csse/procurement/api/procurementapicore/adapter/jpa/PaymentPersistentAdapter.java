package com.csse.procurement.api.procurementapicore.adapter.jpa;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.InvoiceRepository;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.PaymentRepository;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.PurchaseOrderRepository;
import com.csse.procurement.business.entity.Invoice;
import com.csse.procurement.business.entity.Payment;
import com.csse.procurement.business.port.out.GetInvoicePort;
import com.csse.procurement.business.port.out.GetPaymentPort;
import com.csse.procurement.business.port.out.SaveInvoicePort;
import com.csse.procurement.business.port.out.SavePaymentPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PaymentPersistentAdapter implements SavePaymentPort, GetPaymentPort, SaveInvoicePort, GetInvoicePort {
    private final PaymentRepository paymentRepository;
    private final InvoiceRepository invoiceRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    public PaymentPersistentAdapter(PaymentRepository paymentRepository, InvoiceRepository invoiceRepository, PurchaseOrderRepository purchaseOrderRepository) {
        this.paymentRepository = paymentRepository;
        this.invoiceRepository = invoiceRepository;
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @Override
    public void createPayment(Payment payment) {
        if (payment != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Payment dbPayment = mapper.map(payment, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Payment.class);
            paymentRepository.save(dbPayment);
        }
    }

    @Override
    public void updatePayment(Payment payment) {
        Long paymentId = payment.getId();

        if (paymentId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Payment> optionalPayment = paymentRepository.findById(paymentId);
        if (optionalPayment.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Payment existingPayment = optionalPayment.get();

            existingPayment.setPaymentType(payment.getPaymentType());
            existingPayment.setStatus(payment.getStatus());

            paymentRepository.save(existingPayment);
        }
    }

    @Override
    public void deletePaymentById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Payment> optionalPayment = paymentRepository.findById(id);

        if (optionalPayment.isPresent()) {
            paymentRepository.deleteById(id);
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll().stream().map(n->mapper.map(n, Payment.class)).toList();
    }

    @Override
    public Payment getPaymentById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Payment> payment = paymentRepository.findById(id);
        return mapper.map(payment, Payment.class);
    }

    @Override
    public void createInvoice(Invoice invoice) {
        if (invoice != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Invoice dbInvoice = mapper.map(invoice, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Invoice.class);
            PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(invoice.getPurchaseOrder().getId()).orElse(null);
            dbInvoice.setPurchaseOrder(purchaseOrder);
            invoiceRepository.save(dbInvoice);
        }
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        Long invoiceId = invoice.getId();

        if (invoiceId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Invoice> optionalInvoice = invoiceRepository.findById(invoiceId);
        if (optionalInvoice.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Invoice existingInvoice = optionalInvoice.get();

            existingInvoice.setDescription(invoice.getDescription());
            existingInvoice.setDocumentDate(invoice.getDocumentDate());
            existingInvoice.setDueDate(invoice.getDueDate());
            existingInvoice.setTotalAmount(invoice.getTotalAmount());

            if (invoice.getPurchaseOrder() != null) {
                PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(invoice.getPurchaseOrder().getId()).orElse(null);
                existingInvoice.setPurchaseOrder(purchaseOrder);
            }

            invoiceRepository.save(existingInvoice);
        }
    }

    @Override
    public void deleteInvoiceById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Invoice> optionalInvoice = invoiceRepository.findById(id);

        if (optionalInvoice.isPresent()) {
            invoiceRepository.deleteById(id);
        }
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll().stream().map(n->mapper.map(n, Invoice.class)).toList();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Invoice> invoice = invoiceRepository.findById(id);
        return mapper.map(invoice, Invoice.class);
    }
}
