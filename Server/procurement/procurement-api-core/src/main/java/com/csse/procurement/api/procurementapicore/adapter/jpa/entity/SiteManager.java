package com.csse.procurement.api.procurementapicore.adapter.jpa.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SiteManager extends BaseEntity{
    private String userName;
    private String password;
    private String email;
    private String contactNo;
    private String employeeCode;
    private String role;
    private Boolean authorizedStatus;
}
