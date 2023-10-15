package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.business.impl.service.CompanyUseCaseImpl;
import com.csse.procurement.business.impl.service.EmployeeUseCaseImpl;
import com.csse.procurement.business.impl.service.ItemUseCaseImpl;
import com.csse.procurement.business.impl.service.SiteUseCaseImpl;
import com.csse.procurement.business.port.in.CompanyUseCase;
import com.csse.procurement.business.port.in.EmployeeUseCase;
import com.csse.procurement.business.port.in.ItemUseCase;
import com.csse.procurement.business.port.in.SiteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootConfig {

    @Bean
    public SiteUseCase siteUseCase() {
        return new SiteUseCaseImpl();
    }

    @Bean
    public CompanyUseCase companyUseCase() {
        return new CompanyUseCaseImpl();
    }

    @Bean
    public EmployeeUseCase employeeUseCase() {
        return new EmployeeUseCaseImpl();
    }

    @Bean
    public ItemUseCase itemUseCase() {
        return new ItemUseCaseImpl();
    }
}
