package com.example.mandipriceapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private final List<Item> itemList;

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.itemImage.setImageResource(item.getImage());
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText("Price per hour: Rs" + item.getPrice());
        holder.itemQuantity.setText(String.valueOf(item.getQuantity()));

        holder.increaseButton.setOnClickListener(v -> {
            item.setQuantity(item.getQuantity() + 1);
            holder.itemQuantity.setText(String.valueOf(item.getQuantity()));
            if (!RentActivity.cart.contains(item)) {
                RentActivity.cart.add(item);
            }
        });

        holder.decreaseButton.setOnClickListener(v -> {
            if (item.getQuantity() > 0) {
                item.setQuantity(item.getQuantity() - 1);
                holder.itemQuantity.setText(String.valueOf(item.getQuantity()));
                if (item.getQuantity() == 0) {
                    RentActivity.cart.remove(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName, itemPrice, itemQuantity;
        Button increaseButton, decreaseButton;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            increaseButton = itemView.findViewById(R.id.increaseQuantity);
            decreaseButton = itemView.findViewById(R.id.decreaseQuantity);
        }
    }
}
