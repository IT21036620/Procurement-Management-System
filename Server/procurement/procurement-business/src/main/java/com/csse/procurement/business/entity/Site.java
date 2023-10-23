package com.csse.procurement.business.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Site extends BaseEntity{
    private Long id;
    private String siteName;
    private String location;
    private String siteContactNo;
    private SiteManager siteManager;
}
