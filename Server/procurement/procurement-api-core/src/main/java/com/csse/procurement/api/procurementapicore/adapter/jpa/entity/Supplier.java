package com.csse.procurement.api.procurementapicore.adapter.jpa.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Supplier extends BaseEntity {
    private String supplierName;
    private String address;
    private String email;
    private String contactNo;
}
