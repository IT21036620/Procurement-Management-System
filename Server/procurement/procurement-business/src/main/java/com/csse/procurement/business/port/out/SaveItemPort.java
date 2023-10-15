package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Item;
import com.csse.procurement.business.entity.Policy;

public interface SaveItemPort {
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
}
