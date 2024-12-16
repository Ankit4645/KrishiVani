package com.example.mandipriceapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class RentActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Item> itemList = new ArrayList<>();
    public static List<Item> cart = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        recyclerView = findViewById(R.id.recyclerView6);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Add sample items
        itemList.add(new Item("Plough", 500, R.drawable.plough));
        itemList.add(new Item("Sprinkler", 300, R.drawable.sprinkle));
        itemList.add(new Item("Sowing_Machine", 800, R.drawable.sowing));
        itemList.add(new Item("Scaling_machine", 200, R.drawable.scale));
        itemList.add(new Item("Tractor", 1200, R.drawable.tractor));
        itemList.add(new Item("Small_Truck", 1000, R.drawable.truck));
        itemList.add(new Item("Harvester", 1500, R.drawable.harvester));
        itemList.add(new Item("TubeWell", 600, R.drawable.tubewell));

        adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);

        Button viewCartButton = findViewById(R.id.viewCartButton);
        viewCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(RentActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}