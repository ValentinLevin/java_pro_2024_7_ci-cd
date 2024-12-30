package com.example.lesson7.service;

import com.example.lesson7.dto.HelloRequestDTO;
import com.example.lesson7.dto.HelloResponseDTO;

public interface HelloService {
    HelloResponseDTO sayHello(HelloRequestDTO request);
}
