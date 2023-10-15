package com.csse.procurement.business.port.in;

import com.csse.hexa.core.UseCase;
import com.csse.procurement.business.entity.Item;
import com.csse.procurement.business.entity.Supplier;

import java.util.List;

@UseCase
public interface ItemUseCase {
    /**
     * Create item
     * @param item - item
     */
    void createItem(Item item);

    /**
     * Update item
     * @param item - item
     */
    void updateItem(Item item);

    /**
     * Delete item
     * @param id - item id
     */
    void deleteItemById(Long id);

    /**
     * Get all items
     * @return - List of items
     */
    List<Item> getAllItems();

    /**
     * Get item by id
     * @param id - item id
     * @return - item
     */
    Item getItemById(Long id);

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
