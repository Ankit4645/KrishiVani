package com.example.mandipriceapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ViewPager2 viewPager = findViewById(R.id.viewPager);

        List<NewsItem> newsList = new ArrayList<>();
        newsList.add(new NewsItem(R.drawable.news1, "Farmers to resume their march to Delhi on December 14"));
        newsList.add(new NewsItem(R.drawable.news2, "Haryana CM defends MSP"));
        newsList.add(new NewsItem(R.drawable.news3, "Govt Can't fail protest"));
        newsList.add(new NewsItem(R.drawable.news4, "100 Farmers gets Waqf Notice"));
        newsList.add(new NewsItem(R.drawable.news6, "MP farmer erans 40-50 lakhs montly"));
        newsList.add(new NewsItem(R.drawable.news5, "Bengaluru to get international Flower market"));
        newsList.add(new NewsItem(R.drawable.news7, "Jowar new variety developed"));
        newsList.add(new NewsItem(R.drawable.news8, "UP forms 5 member commite"));
        // Add 18 more news items here...

        NewsAdapter adapter = new NewsAdapter(newsList);
        viewPager.setAdapter(adapter);
    }
}
