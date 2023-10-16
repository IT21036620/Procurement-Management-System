package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.business.impl.service.*;
import com.csse.procurement.business.port.in.*;
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

    @Bean
    OrderUseCase orderUseCase() {
        return new OrderUseCaseImpl();
    }

    @Bean
    PaymentUseCase paymentUseCase() {
        return new PaymentUseCaseImpl();
    }
}
