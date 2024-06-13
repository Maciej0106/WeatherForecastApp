package com.weatherforecast.weatherapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityWeatherForecastDto {
    private String city;
    private ForecastDto forecast;
}
