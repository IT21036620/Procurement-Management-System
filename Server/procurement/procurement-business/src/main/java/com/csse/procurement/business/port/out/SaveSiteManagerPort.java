package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.SiteManager;

public interface SaveSiteManagerPort {
    /**
     * Create a site manager
     * @param siteManager - site manager
     */
    void createSiteManager(SiteManager siteManager);

    /**
     * Update a site manager
     * @param siteManager - site manager
     */
    void updateSiteManager(SiteManager siteManager);

    /**
     * Delete a site manager
     * @param siteManagerId - site manager id
     */
    void deleteSiteManagerById(Long siteManagerId);
}
