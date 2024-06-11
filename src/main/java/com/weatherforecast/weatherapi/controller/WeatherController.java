package com.weatherforecast.weatherapi.controller;

import com.weatherforecast.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/forecast")
    public String getWeatherForecast() {
        return weatherService.getForecastForCities();
    }
}

