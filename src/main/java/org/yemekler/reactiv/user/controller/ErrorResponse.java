package org.yemekler.reactiv.user.controller;

public class ErrorResponse {
    private String message;

    // Constructor, getters, and setters
    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
