package com.weatherforecast.weatherapi.client;

import com.weatherforecast.weatherapi.dto.CityWeatherForecastDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather-client", url = "https://api.weatherapi.com/v1")
public interface WeatherClient {
    @GetMapping("/forecast.json")
    CityWeatherForecastDto getWeatherForecast(@RequestParam("key") String apiKey,
                                              @RequestParam("q") String city,
                                              @RequestParam("days") int days);
}

