package com.csse.procurement.api.procurementapicore.adapter.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Policy extends BaseEntity {
    private Long policyNo;
    private String statements;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "madeBy")
    private LineManager madeBy;
}
