package com.example.lesson7.service;

import com.example.lesson7.dto.HelloRequestDTO;
import com.example.lesson7.dto.HelloResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    private static final String MESSAGE_TEMPLATE = "Hello from %s, %s";
    private final String fromName;

    public HelloServiceImpl(@Value("${from-name}")String fromName) {
        this.fromName = fromName;
    }

    public HelloResponseDTO sayHello(HelloRequestDTO request) {
        return new HelloResponseDTO(String.format(MESSAGE_TEMPLATE, this.fromName, request.getName()));
    }
}
