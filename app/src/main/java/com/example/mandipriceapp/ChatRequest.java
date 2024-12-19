package com.example.mandipriceapp;

import java.util.List;

public class ChatRequest {
    private String model;
    private List<MessageRequest> messages;

    public ChatRequest(String model, List<MessageRequest> messages) {
        this.model = model;
        this.messages = messages;
    }
}

