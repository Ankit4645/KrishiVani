package com.example.mandipriceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize ImageButtons
        ImageButton btnMandiPrice = findViewById(R.id.btnMandiPrice);
        ImageButton btnWeather = findViewById(R.id.btnWeather);
        ImageButton btnRent = findViewById(R.id.btnRent);
        ImageButton btnNews = findViewById(R.id.btnNews);
        ImageButton btnchat = findViewById(R.id.btchat);

        // Set OnClickListener for Mandi Price button
        btnMandiPrice.setOnClickListener(v -> {
            // Intent to go to Mandi Price page
            Intent intent = new Intent(DashboardActivity.this, MandiPriceActivity.class);
            startActivity(intent);
        });


        // Set OnClickListener for Weather button
        btnWeather.setOnClickListener(v -> {
            // Intent to go to Weather page (create this activity later)
            Intent intent = new Intent(DashboardActivity.this, WeatherActivity.class);
            startActivity(intent);
        });

        // Set OnClickListener for Rent button
        btnRent.setOnClickListener(v -> {
            // Intent to go to Rent page (create this activity later)
            Intent intent = new Intent(DashboardActivity.this, RentActivity.class);
            startActivity(intent);
        });

        // Set OnClickListener for News button
        btnNews.setOnClickListener(v -> {
            // Intent to go to News page (create this activity later)
            Intent intent = new Intent(DashboardActivity.this, NewsActivity.class);
            startActivity(intent);
        });
        btnchat.setOnClickListener(v -> {
            // Intent to go to Rent page (create this activity later)
            Intent intent = new Intent(DashboardActivity.this, chatBot.class);
            startActivity(intent);
        });
    }
}
