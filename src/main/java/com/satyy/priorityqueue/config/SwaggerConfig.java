package com.satyy.priorityqueue.config;

import com.google.common.base.Predicates;

import io.swagger.annotations.Api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Satyam Singh (satyamsingh00@gmail.com)
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public SwaggerConfig() {
    }

    @Bean
    public Docket apiV1() {
        return docket("v1");
    }


    private Docket docket(final String version) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(Predicates.not(PathSelectors.regex("(/manage.*|/error)")))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metadata(version));
    }

    private ApiInfo metadata(final String versionNumber) {
        return new ApiInfoBuilder()
                .title("Priority Queue")
                .description("Priority Queue API definition is provided here.")
                .version(versionNumber)
                .build();
    }
}
