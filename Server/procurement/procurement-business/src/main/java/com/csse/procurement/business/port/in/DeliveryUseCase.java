package com.csse.procurement.business.port.in;

import com.csse.hexa.core.UseCase;
import com.csse.procurement.business.entity.CreditNote;
import com.csse.procurement.business.entity.Delivery;

import java.util.List;

@UseCase
public interface DeliveryUseCase {
    /**
     * Create delivery
     * @param delivery - delivery
     */
    void createDelivery(Delivery delivery);

    /**
     * Update delivery
     * @param delivery - delivery
     */
    void updateDelivery(Delivery delivery);

    /**
     * Delete delivery
     * @param id - delivery id
     */
    void deleteDeliveryById(Long id);

    /**
     * Get all deliveries
     * @return - List of deliveries
     */
    List<Delivery> getAllDeliveries();

    /**
     * Get delivery by id
     * @param id - delivery id
     * @return - delivery
     */
    Delivery getDeliveryById(Long id);

    /**
     * Create credit note
     * @param creditNote - credit note
     */
    void createCreditNote(CreditNote creditNote);

    /**
     * Update credit note
     * @param creditNote - credit note
     */
    void updateCreditNote(CreditNote creditNote);

    /**
     * Delete credit note
     * @param id - credit note id
     */
    void deleteCreditNoteById(Long id);

    /**
     * Get all credit notes
     * @return - List of credit notes
     */
    List<CreditNote> getAllCreditNotes();

    /**
     * Get credit note by id
     * @param id - credit note id
     * @return - credit note
     */
    CreditNote getCreditNoteById(Long id);
}
