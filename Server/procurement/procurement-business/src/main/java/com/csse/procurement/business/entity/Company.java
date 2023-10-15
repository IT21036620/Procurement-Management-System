package com.csse.procurement.business.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company extends BaseEntity {
    private Long id;
    private String companyName;
    private String hoAddress;
    private String contactNo;
    private String email;
    private List<Policy> policyList;
    private List<Department> departmentList;
    private List<BankAccount> bankAccountList;
}
