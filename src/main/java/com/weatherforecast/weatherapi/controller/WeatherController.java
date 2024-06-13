package com.weatherforecast.weatherapi.controller;

import com.weatherforecast.weatherapi.dto.CityWeatherForecastDto;
import com.weatherforecast.weatherapi.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
@Slf4j
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/forecast")
    public List<CityWeatherForecastDto> getWeatherForecast() {
        log.info("Fetching weather forecasts for configured cities.");
        return weatherService.getForecastForCities();
    }
}
