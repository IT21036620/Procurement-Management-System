package com.csse.procurement.business.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderItem extends BaseEntity {
    private Long id;
    private Integer quantity;
    private String description;
    private Double price;
    private Item item;
}
