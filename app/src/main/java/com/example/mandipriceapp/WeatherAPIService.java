package com.example.mandipriceapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPIService {
    @GET("weather")
    Call<WeatherResponse> getWeatherData(
            @Query("q") String cityName,
            @Query("appid") String apiKey,
            @Query("units") String units
    );
}

