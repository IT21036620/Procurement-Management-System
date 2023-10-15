package com.csse.procurement.api.procurementapicore.adapter.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Site extends BaseEntity{
    private String siteName;
    private String location;
    private String siteContactNo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "siteManagerId")
    private SiteManager siteManager;
}
