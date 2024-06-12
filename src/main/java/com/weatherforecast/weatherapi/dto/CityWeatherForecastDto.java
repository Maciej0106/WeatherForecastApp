package com.weatherforecast.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityWeatherForecastDto {
    private String city;

    @JsonProperty("forecast")
    private ForecastDto forecast;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ForecastDto getForecast() {
        return forecast;
    }

    public void setForecast(ForecastDto forecast) {
        this.forecast = forecast;
    }
}
