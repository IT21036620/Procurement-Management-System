package com.csse.procurement.business.impl.service;

import com.csse.procurement.business.entity.Site;
import com.csse.procurement.business.entity.SiteManager;
import com.csse.procurement.business.exception.BusinessLogicException;
import com.csse.procurement.business.port.in.SiteUseCase;
import com.csse.procurement.business.port.out.GetSiteManagerPort;
import com.csse.procurement.business.port.out.GetSitePort;
import com.csse.procurement.business.port.out.SaveSiteManagerPort;
import com.csse.procurement.business.port.out.SaveSitePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteUseCaseImpl implements SiteUseCase {

    private static final String SITE_NOT_FOUND = "Site not found";
    private static final String SITE_MANAGER_NOT_FOUND = "Site manager not found";

    @Autowired
    private SaveSitePort saveSitePort;
    @Autowired
    private SaveSiteManagerPort saveSiteManagerPort;
    @Autowired
    private GetSitePort getSitePort;
    @Autowired
    private GetSiteManagerPort getSiteManagerPort;

    @Override
    public void createSite(Site site) {
        saveSitePort.createSite(site);
    }

    @Override
    public void updateSite(Site site) {
        Site existingSite = getSitePort.getSiteById(site.getId());

        if (existingSite == null) {
            throw new BusinessLogicException(SITE_NOT_FOUND);
        }

        saveSitePort.updateSite(site);
    }

    @Override
    public void deleteSiteById(Long siteId) {
        saveSitePort.deleteSiteById(siteId);
    }

    @Override
    public List<Site> getAllSites() {
        return getSitePort.getAllSites();
    }

    @Override
    public Site getSiteById(Long siteId) {
        return getSitePort.getSiteById(siteId);
    }

    @Override
    public void createSiteManager(SiteManager siteManager) {

    }

    @Override
    public void updateSiteManager(SiteManager siteManager) {

    }

    @Override
    public void deleteSiteManagerById(Long siteManagerId) {

    }

    @Override
    public List<SiteManager> getAllSiteManagers() {
        return null;
    }

    @Override
    public SiteManager getSiteManagerById(Long siteManagerId) {
        return getSiteManagerPort.getSiteManagerById(siteManagerId);
    }
}
