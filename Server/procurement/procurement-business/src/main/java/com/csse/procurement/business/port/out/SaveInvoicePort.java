package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Invoice;
import com.csse.procurement.business.entity.Payment;

public interface SaveInvoicePort {
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
}
