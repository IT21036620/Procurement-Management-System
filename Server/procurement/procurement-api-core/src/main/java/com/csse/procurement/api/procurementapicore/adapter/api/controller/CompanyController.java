package com.csse.procurement.api.procurementapicore.adapter.api.controller;

import com.csse.procurement.business.port.in.CompanyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyUseCase companyService;

    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    @Autowired
    public CompanyController(CompanyUseCase companyService) {
        this.companyService = companyService;
    }
}
