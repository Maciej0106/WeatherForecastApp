package com.weatherforecast.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ForecastDto {
    @JsonProperty("forecastday")
    private List<WeatherDataDto> forecastDay;


    public List<WeatherDataDto> getForecastDay() {
        return forecastDay;
    }

    public void setForecastDay(List<WeatherDataDto> forecastDay) {
        this.forecastDay = forecastDay;
    }
}
