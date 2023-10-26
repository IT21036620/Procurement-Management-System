package com.csse.procurement.api.procurementapicore.adapter.jpa.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Requisition extends BaseEntity {
    private String reqOrdNo;
    private String details;
    private String status;
    private Double amount;
}
