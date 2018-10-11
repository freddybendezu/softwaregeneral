package com.softwaregeneral.business.poliza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@EnableCircuitBreaker
@EnableHystrixDashboard
public class PolizaBusinessServicesApplication {

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).groupName("VehiculoPoliza").select()
				.apis(RequestHandlerSelectors.basePackage("com.softwaregeneral.business.poliza"))
				.paths(any()).build().apiInfo(new ApiInfo("Vehiculo Poliza Services",
						"Un conjunto de servicios para el proceso de negocio de poliza", "1.0.0", null,
						new Contact("Freddy Bendezu", "https://softwaregeneral.com/fbendezu", null),null, null));
	}

	public static void main(String[] args) {
		SpringApplication.run(PolizaBusinessServicesApplication.class, args);
	}
}
