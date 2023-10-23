package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Delivery;

public interface SaveDeliveryPort {
    /**
     * Create delivery
     * @param delivery - delivery
     */
    void createDelivery(Delivery delivery);

    /**
     * Update delivery
     * @param delivery - delivery
     */
    void updateDelivery(Delivery delivery);

    /**
     * Delete delivery
     * @param id - delivery id
     */
    void deleteDeliveryById(Long id);
}
