package com.example.lesson7.controller;

import com.example.lesson7.dto.HelloRequestDTO;
import com.example.lesson7.dto.HelloResponseDTO;
import com.example.lesson7.service.HelloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @Operation(
            tags = "Тестовые запросы",
            summary = "Приветствие",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Запрос успешно обработан",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = HelloResponseDTO.class
                                    )
                            )
                    )
            }
    )
    @PostMapping("/hello")
    public HelloResponseDTO sayHello(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Обработка на приветствие",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = HelloRequestDTO.class
                            ),
                            examples = {
                                    @ExampleObject(
                                            name = "Test request",
                                            summary = "Тестовый запрос",
                                            value = "{ \"name\": \"Some name\" }"
                                    )
                            }
                    ),
                    required = true
            )
            @Valid @RequestBody() HelloRequestDTO request
    ) {
        return this.helloService.sayHello(request);
    }
}
