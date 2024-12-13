package com.example.mandipriceapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {

    private EditText etCity;
    private TextView tvWeather;
    private Button btnGetWeather;
    private WeatherAPIService weatherAPIService;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        etCity = findViewById(R.id.et_city);
        tvWeather = findViewById(R.id.tv_weather);
        btnGetWeather = findViewById(R.id.btn_get_weather);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherAPIService = retrofit.create(WeatherAPIService.class);

        btnGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = etCity.getText().toString();
                getWeatherData(cityName);
            }
        });
    }

    private void getWeatherData(String cityName) {
        String apiKey = "b9b8cde6aa427ea6bdfa503ecfb4c8df";
        String units = "metric";  // For Celsius
        Call<WeatherResponse> call = weatherAPIService.getWeatherData(cityName, apiKey, units);

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    WeatherResponse weatherResponse = response.body();
                    String weatherInfo = "City: " + weatherResponse.name +
                            "\nTemperature: " + weatherResponse.main.temp + "°C" +
                            "\nHumidity: " + weatherResponse.main.humidity + "%";
                    tvWeather.setText(weatherInfo);
                } else {
                    tvWeather.setText("Error fetching data. Try again.");
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                tvWeather.setText("Network error. Try again.");
            }
        });
    }
}
