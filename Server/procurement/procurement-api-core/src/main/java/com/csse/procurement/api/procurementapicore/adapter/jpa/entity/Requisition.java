package com.csse.procurement.api.procurementapicore.adapter.jpa.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Requisition extends BaseEntity {
    private String reqOrdNo;
    private String details;
    private String status;
}
