package io.dkargo.jpaboard.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .globalResponseMessage(RequestMethod.GET,getResponseMessage());
    }
    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        consumes.add("application/octet-stream;charset=UTF-8");
        consumes.add("multipart/form-data");
        return consumes;
    }
    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        produces.add("application/octet-stream;charset=UTF-8");
        produces.add("multipart/form-data");
        return produces;
    }
    private List<ResponseMessage> getResponseMessage() {
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(
                new ResponseMessageBuilder()
                        .code(200)
                        .message("OK!")
                        .build()
        );
        responseMessages.add(
                new ResponseMessageBuilder()
                        .code(400)
                        .message("Bad Request!")
                        .build()
        );
        responseMessages.add(
                new ResponseMessageBuilder()
                        .code(404)
                        .message("Not Found!")
                        .build()
        );
        responseMessages.add(
                new ResponseMessageBuilder()
                        .code(500)
                        .message("Internal Server Error!")
                        .build()
        );
        return responseMessages;
    }
}