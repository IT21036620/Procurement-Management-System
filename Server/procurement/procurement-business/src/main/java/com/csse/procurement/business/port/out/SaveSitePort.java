package com.csse.procurement.business.port.out;

import com.csse.procurement.business.entity.Site;

public interface SaveSitePort {
    /**
     * Create Site
     * @param site - site
     */
    void createSite(Site site);

    /**
     * Update a site
     * @param site - site
     */
    void updateSite(Site site);

    /**
     * Delete a site by id
     * @param siteId - id
     */
    void deleteSiteById(Long siteId);
}
