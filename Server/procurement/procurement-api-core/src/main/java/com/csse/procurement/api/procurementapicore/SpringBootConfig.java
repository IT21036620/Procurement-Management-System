package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.business.impl.service.SiteUseCaseImpl;
import com.csse.procurement.business.port.in.SiteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootConfig {

    @Bean
    public SiteUseCase siteUseCase() {
        return new SiteUseCaseImpl();
    }
}
