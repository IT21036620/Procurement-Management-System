package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Delivery;

import java.util.List;

public interface GetDeliveryPort {
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
}
