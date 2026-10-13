package com.harsh.userauth.dto;

public class AuthResponse {

    private String message;
    private UserResponse user;

    public AuthResponse() {
    }

    public AuthResponse(String message, UserResponse user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public UserResponse getUser() {
        return user;
    }
}