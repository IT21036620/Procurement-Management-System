package com.csse.procurement.business.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount extends BaseEntity {
    private Long id;
    private String accountNo;
    private String accountType;
    private String accountName;
    private String branch;
}
