package com.circle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    //配置了Swagger的Docket的bean实例
    //这个@Bean没写，找的我，我还以为我电脑坏了
    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.circle.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //配置Swagger信息
    private ApiInfo getApiInfo() {
        //作者信息
        Contact DEFAULT_CONTACT = new Contact("circle", "http://www.khole.top", "2965939109@qq.com");
        return new ApiInfoBuilder()
                .title("circle的博客API文档")
                .description("好货垫底")
                .termsOfServiceUrl("http://www.khole.top")
                .contact(DEFAULT_CONTACT)
                .build();
    }
}