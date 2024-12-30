package com.example.lesson7.exception;

import com.example.lesson7.constant.RESPONSE_STATUS;
import com.example.lesson7.dto.BaseResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    private ResponseEntity<BaseResponseDTO> buildResponseEntity(CustomException exception) {
        return ResponseEntity
                .status(exception.getResponseHttpStatus())
                .body(
                        new BaseResponseDTO(
                                RESPONSE_STATUS.ERROR.getStatus(),
                                exception.getMessage()
                        )
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder strBuilder = new StringBuilder();

        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName;
            try {
                fieldName = ((FieldError) error).getField();
            } catch (ClassCastException ex) {
                fieldName = error.getObjectName();
            }
            String message = error.getDefaultMessage();
            strBuilder.append(String.format("%s: %s", fieldName, message));
        });

        return buildResponseEntity(new ValidationException(strBuilder.toString()));
    }
}
