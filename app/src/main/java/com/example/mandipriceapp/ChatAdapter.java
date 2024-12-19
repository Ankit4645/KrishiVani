package com.example.mandipriceapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_USER = 0;
    private static final int VIEW_TYPE_BOT = 1;

    private List<Message> messages;

    public ChatAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        return messages.get(position).isUser() ? VIEW_TYPE_USER : VIEW_TYPE_BOT;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_USER) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_user_message, parent, false);
            return new UserViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_bot_message, parent, false);
            return new BotViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messages.get(position);
        if (holder instanceof UserViewHolder) {
            ((UserViewHolder) holder).textViewUserMessage.setText(message.getText());
        } else {
            ((BotViewHolder) holder).textViewBotMessage.setText(message.getText());
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    // ViewHolder for User message
    static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewUserMessage;

        UserViewHolder(View itemView) {
            super(itemView);
            textViewUserMessage = itemView.findViewById(R.id.messageText);
        }
    }

    // ViewHolder for Bot message
    static class BotViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBotMessage;

        BotViewHolder(View itemView) {
            super(itemView);
            textViewBotMessage = itemView.findViewById(R.id.messageText);
        }
    }
}
