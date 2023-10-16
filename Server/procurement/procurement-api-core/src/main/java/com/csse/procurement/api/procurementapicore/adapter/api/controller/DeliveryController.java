package com.csse.procurement.api.procurementapicore.adapter.api.controller;

import com.csse.procurement.api.procurementapicore.adapter.api.response.CommonResponse;
import com.csse.procurement.business.entity.CreditNote;
import com.csse.procurement.business.entity.Delivery;
import com.csse.procurement.business.port.in.DeliveryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    private final DeliveryUseCase deliveryService;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    @Autowired
    public DeliveryController(DeliveryUseCase deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public ResponseEntity<String> createDelivery(@RequestBody final Delivery delivery) {
        deliveryService.createDelivery(delivery);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<CommonResponse> updateDelivery(@RequestBody Delivery delivery) {
        deliveryService.updateDelivery(delivery);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated delivery with id: " + delivery.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteDeliveryById(@PathVariable Long id) {
        deliveryService.deleteDeliveryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully deleted payment with id: " + id));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllDeliveries() {
        return ResponseEntity.ok(new CommonResponse(deliveryService.getAllDeliveries()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getDeliveryById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(deliveryService.getDeliveryById(id)));
    }

    @PostMapping("/credit-note")
    public ResponseEntity<String> createCreditNote(@RequestBody final CreditNote creditNote) {
        deliveryService.createCreditNote(creditNote);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/credit-note")
    public ResponseEntity<CommonResponse> updateCreditNote(@RequestBody CreditNote creditNote) {
        deliveryService.updateCreditNote(creditNote);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated credit note with id: " + creditNote.getId()));
    }

    @DeleteMapping("/credit-note/{id}")
    public ResponseEntity<CommonResponse> deleteCreditNoteById(@PathVariable Long id) {
        deliveryService.deleteCreditNoteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully credit note invoice with id: " + id));
    }

    @GetMapping("/credit-note")
    public ResponseEntity<CommonResponse> getAllCreditNotes() {
        return ResponseEntity.ok(new CommonResponse(deliveryService.getAllCreditNotes()));
    }

    @GetMapping("/credit-note/{id}")
    public ResponseEntity<CommonResponse> getCreditNoteById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(deliveryService.getCreditNoteById(id)));
    }
}
