package com.example.lesson7.controller;

import com.example.lesson7.dto.HelloRequestDTO;
import com.example.lesson7.dto.HelloResponseDTO;
import com.example.lesson7.service.HelloService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerTest {
    private final HelloService helloService = Mockito.mock(HelloService.class);

    @Test
    @DisplayName("Check that the controller returns the response from the service")
    void successTest() {
        HelloController helloController = new HelloController(helloService);

        HelloRequestDTO request = new HelloRequestDTO("Some name");
        HelloResponseDTO expectedResponse = new HelloResponseDTO("Response answer");
        Mockito.when(helloService.sayHello(Mockito.any())).thenReturn(expectedResponse);

        HelloResponseDTO actualResponse = helloController.sayHello(request);

        assertThat(actualResponse)
                .isNotNull()
                .isEqualTo(expectedResponse);
    }
}
