package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Item;
import com.csse.procurement.business.entity.Supplier;

public interface SaveSupplierPort {
    /**
     * Create supplier
     * @param supplier - supplier
     */
    void createSupplier(Supplier supplier);

    /**
     * Update supplier
     * @param supplier - supplier
     */
    void updateSupplier(Supplier supplier);

    /**
     * Delete supplier
     * @param id - supplier id
     */
    void deleteSupplierById(Long id);
}
