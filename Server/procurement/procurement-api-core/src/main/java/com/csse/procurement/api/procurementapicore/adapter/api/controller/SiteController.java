package com.csse.procurement.api.procurementapicore.adapter.api.controller;

import com.csse.procurement.api.procurementapicore.adapter.api.request.SiteRequest;
import com.csse.procurement.api.procurementapicore.adapter.api.response.CommonResponse;
import com.csse.procurement.business.entity.Site;
import com.csse.procurement.business.entity.SiteManager;
import com.csse.procurement.business.port.in.SiteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/site")
public class SiteController {

    private final SiteUseCase siteService;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    @Autowired
    public SiteController(SiteUseCase siteUseCase) {
        this.siteService = siteUseCase;
    }

    @PostMapping
    public ResponseEntity<String> createSite(@RequestBody final SiteRequest request) {
        Site site = mapper.map(request, Site.class);
        SiteManager siteManager = mapper.map(request.getSiteManager(), SiteManager.class);
        site.setSiteManager(siteManager);
        siteService.createSite(site);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<CommonResponse> updateSite(@RequestBody SiteRequest request) {
        Site site = mapper.map(request, Site.class);
        SiteManager siteManager = mapper.map(request.getSiteManager(), SiteManager.class);
        site.setSiteManager(siteManager);
        siteService.updateSite(site);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated site with id: " + site.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteSiteById(@PathVariable Long id) {
        siteService.deleteSiteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully delete site with id: " + id));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllSites() {
        return ResponseEntity.ok(new CommonResponse(siteService.getAllSites()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getSiteById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(siteService.getSiteById(id)));
    }
}
