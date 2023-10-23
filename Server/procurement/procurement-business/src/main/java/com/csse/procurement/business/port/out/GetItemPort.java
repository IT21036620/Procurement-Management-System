package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Department;
import com.csse.procurement.business.entity.Item;

import java.util.List;

public interface GetItemPort {
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
}
