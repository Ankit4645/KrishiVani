package com.example.mandipriceapp;

import java.util.List;

public class ChatResponse {
    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    public static class Choice {
        private MessageResponse message;

        public MessageResponse getMessage() {
            return message;
        }
    }

    public static class MessageResponse {
        private String content;

        public String getContent() {
            return content;
        }
    }
}