package com.weatherforecast.weatherapi.service;

import com.weatherforecast.weatherapi.client.WeatherClient;
import com.weatherforecast.weatherapi.config.WeatherApiProperties;
import com.weatherforecast.weatherapi.dto.CityWeatherForecastDto;
import com.weatherforecast.weatherapi.exception.CityNotFoundException;
import com.weatherforecast.weatherapi.exception.ExternalServiceInvocationException;
import com.weatherforecast.weatherapi.exception.InvalidApiKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    private final WeatherClient weatherClient;
    private final WeatherApiProperties properties;

    public WeatherService(WeatherClient weatherClient, WeatherApiProperties properties) {
        this.weatherClient = weatherClient;
        this.properties = properties;
    }

    public List<CityWeatherForecastDto> getForecastForCities() {
        List<CityWeatherForecastDto> forecasts = new ArrayList<>();
        for (String city : properties.getCities()) {
            try {
                logger.info("Fetching weather forecast for city: {}", city);
                CityWeatherForecastDto forecast = weatherClient.getWeatherForecast(properties.getApiKey(), city, 3);
                forecast.setCity(city); // Ustawienie pola city
                forecasts.add(forecast);
            } catch (CityNotFoundException e) {
                logger.error("City not found: {}", city, e);
                // Optional: handle specific exception
            } catch (ExternalServiceInvocationException e) {
                logger.error("Error invoking external service for city: {}", city, e);
                // Optional: handle specific exception
            } catch (InvalidApiKeyException e) {
                logger.error("Invalid API key provided", e);
                // Optional: handle specific exception
            } catch (Exception e) {
                logger.error("Error fetching weather forecast for city: {}", city, e);
                // Optional: handle generic exception
            }
        }
        return forecasts;
    }
}
