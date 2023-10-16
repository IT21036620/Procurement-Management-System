package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.CreditNote;

import java.util.List;

public interface GetCreditNotePort {
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
