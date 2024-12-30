package com.example.lesson7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(
        title = "Ответ на запрос /hello"
)
@Getter
public class HelloResponseDTO {
    @Schema(
            title = "Текст приветствия",
            example = "Hello from User, Some name"
    )
    @JsonProperty("message")
    private final String message;

    public HelloResponseDTO(String message) {
        this.message = message;
    }
}
