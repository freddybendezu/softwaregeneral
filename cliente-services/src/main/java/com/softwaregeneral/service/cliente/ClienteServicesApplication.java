package com.softwaregeneral.service.cliente;

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
public class ClienteServicesApplication {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Vehiculo").select()
                .apis(RequestHandlerSelectors.basePackage("com.softwaregeneral.service.cliente"))
                .paths(any()).build().apiInfo(new ApiInfo("Cliente Services",
                        "Todos los datos de los clientes", "1.0.0", null,
                        new Contact("Fredy Bendezu", "https://softwaregenerales.com/fbendezu", null),null, null));
    }

	public static void main(String[] args) {
		SpringApplication.run(ClienteServicesApplication.class, args);
	}
}
