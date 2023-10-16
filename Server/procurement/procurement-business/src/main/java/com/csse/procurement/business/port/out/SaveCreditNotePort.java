package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.CreditNote;

public interface SaveCreditNotePort {
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
}
