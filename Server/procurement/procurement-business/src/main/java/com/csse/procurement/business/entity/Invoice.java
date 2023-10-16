package com.csse.procurement.business.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends BaseEntity {
    private Long id;
    private String description;
    private LocalDateTime documentDate;
    private LocalDateTime dueDate;
    private Double totalAmount;
    private PurchaseOrder purchaseOrder;
}
