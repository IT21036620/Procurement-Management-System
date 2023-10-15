package com.csse.procurement.business.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Policy extends BaseEntity {
    private Long id;
    private Long policyNo;
    private String statements;
    private LineManager madeBy;
}
