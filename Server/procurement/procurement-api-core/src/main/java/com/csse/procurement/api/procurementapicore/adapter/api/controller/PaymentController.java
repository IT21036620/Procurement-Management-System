package com.csse.procurement.api.procurementapicore.adapter.api.controller;

import com.csse.procurement.api.procurementapicore.adapter.api.response.CommonResponse;
import com.csse.procurement.business.entity.Invoice;
import com.csse.procurement.business.entity.Payment;
import com.csse.procurement.business.port.in.PaymentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentUseCase paymentService;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    @Autowired
    public PaymentController(PaymentUseCase paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<String> createPayment(@RequestBody final Payment payment) {
        paymentService.createPayment(payment);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<CommonResponse> updatePayment(@RequestBody Payment payment) {
        paymentService.updatePayment(payment);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated payment with id: " + payment.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deletePaymentById(@PathVariable Long id) {
        paymentService.deletePaymentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully deleted payment with id: " + id));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllPayments() {
        return ResponseEntity.ok(new CommonResponse(paymentService.getAllPayments()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(paymentService.getPaymentById(id)));
    }

    @PostMapping("/invoice")
    public ResponseEntity<String> createInvoice(@RequestBody final Invoice invoice) {
        paymentService.createInvoice(invoice);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/invoice")
    public ResponseEntity<CommonResponse> updateInvoice(@RequestBody Invoice invoice) {
        paymentService.updateInvoice(invoice);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated invoice with id: " + invoice.getId()));
    }

    @DeleteMapping("/invoice/{id}")
    public ResponseEntity<CommonResponse> deleteInvoiceById(@PathVariable Long id) {
        paymentService.deleteInvoiceById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully deleted invoice with id: " + id));
    }

    @GetMapping("/invoice")
    public ResponseEntity<CommonResponse> getAllInvoices() {
        return ResponseEntity.ok(new CommonResponse(paymentService.getAllInvoices()));
    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<CommonResponse> getInvoiceById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(paymentService.getInvoiceById(id)));
    }
}
