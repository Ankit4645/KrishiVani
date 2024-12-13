package com.example.mandipriceapp;

public class WeatherResponse {
    public Main main;
    public String name;

    public class Main {
        public double temp;
        public double humidity;
    }
}
