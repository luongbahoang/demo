package com.example.demo.dto.respond;

public class RespondMessage {
    private String message;

    public RespondMessage(String message) {
        this.message = message;
    }

    public RespondMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
