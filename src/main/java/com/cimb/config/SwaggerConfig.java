package com.cimb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Config.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Creates a new {@link Docket} for swagger documentation.
     *
     * @return {@link Docket} instance
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo());
    }

    /**
     * Method that defines api info for swagger.
     *
     * @return instance of {@link ApiInfo}
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Banking API")
                .description("This API is used to register customer with bank, fetch customer bank account details and perform transactions.")
                .contact(new Contact("Mohammed Irfan Mukthar", null, "irfan.mukthar29@gmail.com"))
                .termsOfServiceUrl(null)
                .version("1.0")
                .build();
    }
}
