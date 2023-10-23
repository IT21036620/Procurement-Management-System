package com.csse.procurement.api.procurementapicore.adapter.api.request;

import com.csse.hexa.core.Request;
import com.csse.procurement.business.entity.SiteManager;
import lombok.Getter;

@Getter
public class SiteRequest implements Request {
    private Long id;
    private String siteName;
    private String location;
    private String siteContactNo;
    private SiteManagerRequest siteManager;
}
