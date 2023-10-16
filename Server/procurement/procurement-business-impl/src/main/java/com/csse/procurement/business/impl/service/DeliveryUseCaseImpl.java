package com.csse.procurement.business.impl.service;

import com.csse.procurement.business.entity.CreditNote;
import com.csse.procurement.business.entity.Delivery;
import com.csse.procurement.business.exception.BusinessLogicException;
import com.csse.procurement.business.port.in.DeliveryUseCase;
import com.csse.procurement.business.port.out.GetCreditNotePort;
import com.csse.procurement.business.port.out.GetDeliveryPort;
import com.csse.procurement.business.port.out.SaveCreditNotePort;
import com.csse.procurement.business.port.out.SaveDeliveryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryUseCaseImpl implements DeliveryUseCase {
    private static final String DELIVERY_NOT_FOUND = "Delivery not found";
    private static final String CREDIT_NOTE_NOT_FOUND = "Credit note not found";

    @Autowired
    private SaveDeliveryPort saveDeliveryPort;
    @Autowired
    private GetDeliveryPort getDeliveryPort;
    @Autowired
    private SaveCreditNotePort saveCreditNotePort;
    @Autowired
    private GetCreditNotePort getCreditNotePort;

    @Override
    public void createDelivery(Delivery delivery) {
        saveDeliveryPort.createDelivery(delivery);
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        Delivery existingDelivery = getDeliveryPort.getDeliveryById(delivery.getId());

        if (existingDelivery == null) {
            throw new BusinessLogicException(DELIVERY_NOT_FOUND);
        }

        saveDeliveryPort.updateDelivery(delivery);
    }

    @Override
    public void deleteDeliveryById(Long id) {
        saveDeliveryPort.deleteDeliveryById(id);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return getDeliveryPort.getAllDeliveries();
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        return getDeliveryPort.getDeliveryById(id);
    }

    @Override
    public void createCreditNote(CreditNote creditNote) {
        saveCreditNotePort.createCreditNote(creditNote);
    }

    @Override
    public void updateCreditNote(CreditNote creditNote) {
        CreditNote existingCreditNote = getCreditNotePort.getCreditNoteById(creditNote.getId());

        if (existingCreditNote == null) {
            throw new BusinessLogicException(CREDIT_NOTE_NOT_FOUND);
        }

        saveCreditNotePort.updateCreditNote(creditNote);
    }

    @Override
    public void deleteCreditNoteById(Long id) {
        saveCreditNotePort.deleteCreditNoteById(id);
    }

    @Override
    public List<CreditNote> getAllCreditNotes() {
        return getCreditNotePort.getAllCreditNotes();
    }

    @Override
    public CreditNote getCreditNoteById(Long id) {
        return getCreditNotePort.getCreditNoteById(id);
    }
}
