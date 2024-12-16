package com.example.mandipriceapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CartActivity extends AppCompatActivity {
    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        cartAdapter = new CartAdapter(RentActivity.cart);
        cartRecyclerView.setAdapter(cartAdapter);

        Button confirmOrderButton = findViewById(R.id.confirmOrderButton);
        confirmOrderButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, ReceiptActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
