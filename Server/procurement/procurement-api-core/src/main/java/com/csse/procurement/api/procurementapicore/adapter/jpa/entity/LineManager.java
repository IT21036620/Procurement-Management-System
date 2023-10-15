package com.csse.procurement.api.procurementapicore.adapter.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class LineManager extends  BaseEntity{
    private String userName;
    private String password;
    private String email;
    private String contactNo;
    private String employeeCode;
    private String role;
    private String managementCode;
    private Boolean authorizedStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "policyId")
    private List<Policy> policyList;
}
