package com.example.mandipriceapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiptActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        TextView receiptTextView = findViewById(R.id.receiptTextView);
        StringBuilder receipt = new StringBuilder("Receipt:\n\n");

        double total = 0;
        for (Item item : RentActivity.cart) {
            receipt.append(item.getName())
                    .append(" x ")
                    .append(item.getQuantity())
                    .append(" = Rs")
                    .append(item.getPrice() * item.getQuantity())
                    .append("\n");
            total += item.getPrice() * item.getQuantity();
        }
        receipt.append("\nTotal: Rs").append(total);

        receiptTextView.setText(receipt.toString());

        Button okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> {
            RentActivity.cart.clear();
            Intent intent = new Intent(ReceiptActivity.this, RentActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
