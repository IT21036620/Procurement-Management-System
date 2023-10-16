package com.csse.procurement.business.entity;

import com.csse.procurement.business.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery extends BaseEntity {
    private Long id;
    private String deliveryAddress;
    private DeliveryStatus status;
    private PurchaseOrder purchaseOrder;
}
