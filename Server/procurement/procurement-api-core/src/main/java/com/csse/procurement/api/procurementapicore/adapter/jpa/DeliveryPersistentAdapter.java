package com.csse.procurement.api.procurementapicore.adapter.jpa;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.CreditNoteRepository;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.DeliveryRepository;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.PurchaseOrderRepository;
import com.csse.procurement.business.entity.CreditNote;
import com.csse.procurement.business.entity.Delivery;
import com.csse.procurement.business.port.out.GetCreditNotePort;
import com.csse.procurement.business.port.out.GetDeliveryPort;
import com.csse.procurement.business.port.out.SaveCreditNotePort;
import com.csse.procurement.business.port.out.SaveDeliveryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DeliveryPersistentAdapter implements SaveDeliveryPort, GetDeliveryPort, SaveCreditNotePort, GetCreditNotePort {
    private final DeliveryRepository deliveryRepository;
    private final CreditNoteRepository creditNoteRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    public DeliveryPersistentAdapter(DeliveryRepository deliveryRepository, CreditNoteRepository creditNoteRepository, PurchaseOrderRepository purchaseOrderRepository) {
        this.deliveryRepository = deliveryRepository;
        this.creditNoteRepository = creditNoteRepository;
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @Override
    public void createDelivery(Delivery delivery) {
        if (delivery != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Delivery dbDelivery = mapper.map(delivery, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Delivery.class);
            PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(delivery.getPurchaseOrder().getId()).orElse(null);
            dbDelivery.setStatus(String.valueOf(delivery.getStatus()));
            dbDelivery.setPurchaseOrder(purchaseOrder);
            deliveryRepository.save(dbDelivery);
        }
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        Long deliveryId = delivery.getId();

        if (deliveryId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (optionalDelivery.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Delivery existingDelivery = optionalDelivery.get();

            existingDelivery.setDeliveryAddress(delivery.getDeliveryAddress());
            existingDelivery.setStatus(String.valueOf(delivery.getStatus()));

            if (delivery.getPurchaseOrder() != null) {
                PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(delivery.getPurchaseOrder().getId()).orElse(null);
                existingDelivery.setPurchaseOrder(purchaseOrder);
            }

            deliveryRepository.save(existingDelivery);
        }
    }

    @Override
    public void deleteDeliveryById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Delivery> optionalDelivery = deliveryRepository.findById(id);

        if (optionalDelivery.isPresent()) {
            deliveryRepository.deleteById(id);
        }
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll().stream().map(n->mapper.map(n, Delivery.class)).toList();
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Delivery> delivery = deliveryRepository.findById(id);
        return mapper.map(delivery, Delivery.class);
    }

    @Override
    public void createCreditNote(CreditNote creditNote) {
        if (creditNote != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.CreditNote dbCreditNote = mapper.map(creditNote, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.CreditNote.class);
            PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(creditNote.getPurchaseOrder().getId()).orElse(null);
            dbCreditNote.setPurchaseOrder(purchaseOrder);
            creditNoteRepository.save(dbCreditNote);
        }
    }

    @Override
    public void updateCreditNote(CreditNote creditNote) {
        Long creditNoteId = creditNote.getId();

        if (creditNoteId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.CreditNote> optionalCreditNote = creditNoteRepository.findById(creditNoteId);
        if (optionalCreditNote.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.CreditNote existingCreditNote = optionalCreditNote.get();

            existingCreditNote.setDescription(creditNote.getDescription());
            existingCreditNote.setAmount(creditNote.getAmount());

            if (creditNote.getPurchaseOrder() != null) {
                PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(creditNote.getPurchaseOrder().getId()).orElse(null);
                existingCreditNote.setPurchaseOrder(purchaseOrder);
            }

            creditNoteRepository.save(existingCreditNote);
        }
    }

    @Override
    public void deleteCreditNoteById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.CreditNote> optionalCreditNote = creditNoteRepository.findById(id);

        if (optionalCreditNote.isPresent()) {
            creditNoteRepository.deleteById(id);
        }
    }

    @Override
    public List<CreditNote> getAllCreditNotes() {
        return creditNoteRepository.findAll().stream().map(n->mapper.map(n, CreditNote.class)).toList();
    }

    @Override
    public CreditNote getCreditNoteById(Long id) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.CreditNote> creditNote = creditNoteRepository.findById(id);
        return mapper.map(creditNote, CreditNote.class);
    }
}
