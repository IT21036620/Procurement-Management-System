package com.csse.procurement.business.port.in;

import com.csse.hexa.core.UseCase;
import com.csse.procurement.business.entity.Site;
import com.csse.procurement.business.entity.SiteManager;

import java.util.List;

@UseCase
public interface SiteUseCase {
    /**
     * Create Site
     * @param site - site
     */
    void createSite(Site site);

    /**
     * Update site
     * @param site - site
     */
    void updateSite(Site site);

    /**
     * Delete Site
     * @param siteId - site id
     */

    void deleteSiteById(Long siteId);

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
