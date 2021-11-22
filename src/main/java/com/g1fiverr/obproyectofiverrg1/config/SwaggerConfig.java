package com.g1fiverr.obproyectofiverrg1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuración del Swagger (clase responsable por documentar los métodos utilizados en la API
 * Accesible en url:port/swagger-ui/
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Proyect Fiverr, de OpenBootcamp",
                "Library API REST docs",
                "1.0",
                "http://www.google.com",
                new Contact("Grupo 1",
                        "https://www.google.com",
                        "open-b-fiverr@gmail.com"),
                "OB SA",
                "http://www.google.com",
                Collections.emptyList());
    }
}
