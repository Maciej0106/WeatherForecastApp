package com.weatherforecast.weatherapi.service;

import com.weatherforecast.weatherapi.client.WeatherClient;
import com.weatherforecast.weatherapi.config.WeatherApiProperties;
import com.weatherforecast.weatherapi.dto.CityWeatherForecastDto;
import com.weatherforecast.weatherapi.exception.CityNotFoundException;
import com.weatherforecast.weatherapi.exception.ExternalServiceInvocationException;
import com.weatherforecast.weatherapi.exception.InvalidApiKeyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherClient weatherClient;
    private final WeatherApiProperties properties;

    public List<CityWeatherForecastDto> getForecastForCities() {
        List<CityWeatherForecastDto> forecasts = new ArrayList<>();
        for (String city : properties.getCities()) {
            try {
                log.info("Fetching weather forecast for city: {}", city);
                CityWeatherForecastDto forecast = weatherClient.getWeatherForecast(properties.getApiKey(), city, 3);
                forecast.setCity(city);
                forecasts.add(forecast);
            } catch (CityNotFoundException e) {
                log.error("City not found: {}", city, e);

            } catch (ExternalServiceInvocationException e) {
                log.error("Error invoking external service for city: {}", city, e);

            } catch (InvalidApiKeyException e) {
                log.error("Invalid API key provided", e);

            } catch (Exception e) {
                log.error("Error fetching weather forecast for city: {}", city, e);

            }
        }
        return forecasts;
    }
}
