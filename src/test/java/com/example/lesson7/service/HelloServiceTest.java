package com.example.lesson7.service;

import com.example.lesson7.dto.HelloRequestDTO;
import com.example.lesson7.dto.HelloResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {
    private static final String MESSAGE_TEMPLATE = "Hello from %s, %s";

    @Value("${from-name")
    private String fromName;

    @Test
    @DisplayName("Check that the service returns a message that matches the template")
    void answerTest() {
        HelloService helloService = new HelloServiceImpl(fromName);

        String name = "Some name";

        HelloRequestDTO request = new HelloRequestDTO(name);
        HelloResponseDTO expectedResponse = new HelloResponseDTO(String.format(MESSAGE_TEMPLATE, fromName, name));

        HelloResponseDTO actualResponse =  helloService.sayHello(request);

        assertThat(actualResponse)
                .isNotNull()
                .extracting("message")
                .isEqualTo(expectedResponse.getMessage());
    }
}
