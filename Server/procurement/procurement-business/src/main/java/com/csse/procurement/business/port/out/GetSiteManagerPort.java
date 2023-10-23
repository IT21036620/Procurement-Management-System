package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.SiteManager;

import java.util.List;

public interface GetSiteManagerPort {
    /**
     * Get all site managers
     * @return - List of site managers
     */
    List<SiteManager> getAllSiteManagers();

    /**
     * Get site manager by id
     * @param siteManagerId - site manager id
     * @return site manager
     */
    SiteManager getSiteManagerById(Long siteManagerId);
}
