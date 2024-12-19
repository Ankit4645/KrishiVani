package com.example.mandipriceapp;

public class MessageRequest {
    private String role;
    private String content;

    public MessageRequest(String role, String content) {
        this.role = role;  // "user" or "assistant"
        this.content = content;
    }
}

