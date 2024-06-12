package com.weatherforecast.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDataDto {
    @JsonProperty("date")
    private String date;

    @JsonProperty("day")
    private DayDataDto day;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DayDataDto getDay() {
        return day;
    }

    public void setDay(DayDataDto day) {
        this.day = day;
    }
}

