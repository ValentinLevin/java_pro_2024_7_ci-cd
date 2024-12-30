package com.example.lesson7.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Schema(
        title = "Запрос на endpoint /hello"
)
@Getter
public class HelloRequestDTO extends BaseResponseDTO{
    @Schema(
            title = "Имя приветствующего",
            example = "Some name"
    )
    @NotBlank(message = "Name is required")
    private final String name;

    public HelloRequestDTO(
            @NotBlank(message = "Name is required")
            @JsonProperty("name") String name
    ) {
        this.name = name;
    }
}
