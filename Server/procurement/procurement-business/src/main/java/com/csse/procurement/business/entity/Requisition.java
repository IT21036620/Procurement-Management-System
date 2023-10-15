package com.csse.procurement.business.entity;

import com.csse.procurement.business.enums.RequisitionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Requisition extends BaseEntity {
    private Long id;
    private String reqOrdNo;
    private String details;
    private RequisitionStatus status;
}
