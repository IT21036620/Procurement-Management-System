package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Site;

import java.util.List;

public interface GetSitePort {
    /**
     * Get all sites
     * @return - List of sites
     */
    List<Site> getAllSites();

    /**
     * Get a site by id
     * @param siteId - site id
     * @return - site
     */
    Site getSiteById(Long siteId);
}
