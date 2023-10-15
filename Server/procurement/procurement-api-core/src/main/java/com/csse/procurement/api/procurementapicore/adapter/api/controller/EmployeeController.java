package com.csse.procurement.api.procurementapicore.adapter.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();
}
