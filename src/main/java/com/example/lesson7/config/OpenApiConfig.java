package com.example.lesson7.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        Info info =
                new Info()
                        .title("Домашнее задание по курсу Java Pro 2024")
                        .description(
                                "<p><i>Студент: Валентин Левин</i></p>" +
                                        "<h2>7. CI/CD </h2> "
                        );
        return new OpenAPI().info(info);
    }
}
