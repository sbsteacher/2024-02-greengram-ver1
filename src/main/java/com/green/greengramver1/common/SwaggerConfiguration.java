package com.green.greengramver1.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;


@OpenAPIDefinition(
    info = @Info(
        title = "GreenGram",
        version = "v1",
        description = "그린그램 SNS"
    )
)
public class SwaggerConfiguration {

}
