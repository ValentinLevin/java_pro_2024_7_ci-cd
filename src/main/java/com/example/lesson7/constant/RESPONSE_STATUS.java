package com.example.lesson7.constant;

public enum RESPONSE_STATUS {
    SUCCESS("success"),
    ERROR("error");

    private final String status;

    public String getStatus() {
        return this.status;
    }

    RESPONSE_STATUS(String status) {
        this.status = status;
    }
}
