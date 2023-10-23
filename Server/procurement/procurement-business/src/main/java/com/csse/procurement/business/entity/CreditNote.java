package com.csse.procurement.business.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditNote extends BaseEntity {
    private Long id;
    private String description;
    private Double amount;
    private PurchaseOrder purchaseOrder;
}
