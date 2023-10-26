package com.csse.procurement.business.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item extends BaseEntity {
    private Long id;
    private String name;
    private String description;
    private String image;
    private String category;
    private Double price;
    private Supplier supplier;
}
