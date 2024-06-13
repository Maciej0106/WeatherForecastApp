package com.weatherforecast.weatherapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ForecastDto {
    private List<WeatherDataDto> forecastday;
}
