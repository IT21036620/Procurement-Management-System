package com.csse.procurement.api.procurementapicore.adapter.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class CreditNote extends BaseEntity {
    private String description;
    private Double amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchaseOrderId")
    private PurchaseOrder purchaseOrder;
}
