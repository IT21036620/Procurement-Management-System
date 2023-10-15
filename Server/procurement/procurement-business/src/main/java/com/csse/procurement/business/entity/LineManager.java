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
public class LineManager extends BaseEntity{
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String contactNo;
    private String employeeCode;
    private String role;
    private String managementCode;
    private Boolean authorizedStatus;
    private Department department;
    private Company company;
}
