package com.csse.procurement.api.procurementapicore.adapter.jpa;

import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.SiteManagerRepository;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.SiteRepository;
import com.csse.procurement.business.entity.Site;
import com.csse.procurement.business.entity.SiteManager;
import com.csse.procurement.business.port.out.GetSiteManagerPort;
import com.csse.procurement.business.port.out.GetSitePort;
import com.csse.procurement.business.port.out.SaveSiteManagerPort;
import com.csse.procurement.business.port.out.SaveSitePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SitePersistentAdapter implements SaveSitePort, SaveSiteManagerPort, GetSitePort, GetSiteManagerPort {
    private final SiteRepository siteRepository;
    private final SiteManagerRepository siteManagerRepository;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    public SitePersistentAdapter(SiteRepository siteRepository, SiteManagerRepository siteManagerRepository) {
        this.siteRepository = siteRepository;
        this.siteManagerRepository = siteManagerRepository;
    }

    @Override
    public void createSite(Site site) {
        if (site != null) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Site dbSite = mapper.map(site, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Site.class);

            if (site.getSiteContactNo() != null) {
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SiteManager siteManager = mapper.map(site.getSiteManager(), com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SiteManager.class);
                siteManagerRepository.save(siteManager);
                dbSite.setSiteManager(siteManager);
            }
            siteRepository.save(dbSite);
        }
    }

    @Override
    public void updateSite(Site site) {
        Long siteId = site.getId();

        if (siteId == null) {
            return;
        }

        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Site> existingSiteOptional = siteRepository.findById(siteId);
        if (existingSiteOptional.isPresent()) {
            com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Site existingSite = existingSiteOptional.get();

            existingSite.setSiteName(site.getSiteName());
            existingSite.setLocation(site.getLocation());
            existingSite.setSiteContactNo(site.getSiteContactNo());

            if (site.getSiteManager().getId() != null) {
                Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SiteManager> dbSiteManager = siteManagerRepository.findById(site.getSiteManager().getId());
                com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SiteManager siteManager = mapper.map(dbSiteManager, com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SiteManager.class);

                if (dbSiteManager.isPresent()) {
                    existingSite.setSiteManager(siteManager);
                }
            }

            siteRepository.save(existingSite);
        }
    }


    @Override
    public void deleteSiteById(Long siteId) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Site> optionalSite = siteRepository.findById(siteId);

        if (optionalSite.isPresent()) {
            siteRepository.deleteById(siteId);
        }
    }

    @Override
    public List<Site> getAllSites() {
        return siteRepository.findAll().stream().map(n->mapper.map(n, Site.class)).toList();
    }

    @Override
    public Site getSiteById(Long siteId) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Site> site = siteRepository.findById(siteId);
        return mapper.map(site, Site.class);
    }

    @Override
    public List<SiteManager> getAllSiteManagers() {
        return null;
    }

    @Override
    public SiteManager getSiteManagerById(Long siteManagerId) {
        Optional<com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SiteManager> siteManager = siteManagerRepository.findById(siteManagerId);
        return mapper.map(siteManager, SiteManager.class);
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
}
