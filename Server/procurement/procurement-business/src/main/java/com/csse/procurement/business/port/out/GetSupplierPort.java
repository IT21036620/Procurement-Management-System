package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Item;
import com.csse.procurement.business.entity.Supplier;

import java.util.List;

public interface GetSupplierPort {
    /**
     * Get all suppliers
     * @return - List of suppliers
     */
    List<Supplier> getAllSupplier();

    /**
     * Get supplier by id
     * @param id - supplier id
     * @return - supplier
     */
    Supplier getSupplierById(Long id);
}
