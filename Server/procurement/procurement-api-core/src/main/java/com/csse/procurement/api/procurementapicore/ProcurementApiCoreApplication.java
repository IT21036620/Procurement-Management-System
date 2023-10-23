package com.csse.procurement.api.procurementapicore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
public class ProcurementApiCoreApplication {

	public static void main(String[] args) {
		try{
			SpringApplication.run(ProcurementApiCoreApplication.class, args);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
