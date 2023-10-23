package com.csse.procurement.api.procurementapicore.adapter.api.controller;

import com.csse.procurement.api.procurementapicore.adapter.api.request.SiteRequest;
import com.csse.procurement.api.procurementapicore.adapter.api.response.CommonResponse;
import com.csse.procurement.business.entity.Company;
import com.csse.procurement.business.entity.Department;
import com.csse.procurement.business.entity.Site;
import com.csse.procurement.business.entity.SiteManager;
import com.csse.procurement.business.port.in.CompanyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyUseCase companyService;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    @Autowired
    public CompanyController(CompanyUseCase companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody final Company company) {
        companyService.createCompany(company);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<CommonResponse> updateCompany(@RequestBody Company company) {
        companyService.updateCompany(company);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("updated company with id: " + company.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteCompanyById(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("successfully deleted company with id: " + id));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllCompanies() {
        return ResponseEntity.ok(new CommonResponse(companyService.getAllCompanies()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(new CommonResponse(companyService.getCompanyById(id)));
    }
}
