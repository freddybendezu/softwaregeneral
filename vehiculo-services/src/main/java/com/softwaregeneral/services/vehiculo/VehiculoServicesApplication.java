package com.softwaregeneral.services.vehiculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class VehiculoServicesApplication {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Vehiculo").select()
                .apis(RequestHandlerSelectors.basePackage("com.softwaregeneral.services.vehiculo"))
                .paths(any()).build().apiInfo(new ApiInfo("Vehiculo Services",
                        "Todas las marcas y modelos de vehiculos", "1.0.0", null,
                        new Contact("Freddy Bendezu", "https://softwaregenerales.com/fbendezu", null),null, null));
    }

	public static void main(String[] args) {
		SpringApplication.run(VehiculoServicesApplication.class, args);
	}
}
