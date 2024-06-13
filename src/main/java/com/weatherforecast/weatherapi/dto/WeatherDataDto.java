package com.weatherforecast.weatherapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherDataDto {
    private String date;
    private DayDataDto day;
}
