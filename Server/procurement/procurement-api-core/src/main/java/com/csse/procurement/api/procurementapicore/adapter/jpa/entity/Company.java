package com.csse.procurement.api.procurementapicore.adapter.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Company extends BaseEntity {
    private String companyName;
    private String hoAddress;
    private String contactNo;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "policyId")
    private List<Policy> policyList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentId")
    private List<Department> departmentList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bankAccountId")
    private List<BankAccount> bankAccountList;
}
