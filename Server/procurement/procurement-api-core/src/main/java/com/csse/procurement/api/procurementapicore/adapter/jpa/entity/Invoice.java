package com.csse.procurement.api.procurementapicore.adapter.jpa.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
public class Invoice extends BaseEntity {
    private String description;
    private LocalDateTime documentDate;
    private LocalDateTime dueDate;
    private Double totalAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchaseOrderId")
    private PurchaseOrder purchaseOrder;
}
