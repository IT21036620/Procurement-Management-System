package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Invoice;

import java.util.List;

public interface GetInvoicePort {
    /**
     * Get all invoices
     * @return - List of invoices
     */
    List<Invoice> getAllInvoices();

    /**
     * Get an invoice by id
     * @param id - invoice id
     * @return - invoice
     */
    Invoice getInvoiceById(Long id);
}
