package com.weatherforecast.weatherapi.service;

import com.weatherforecast.weatherapi.client.WeatherClient;
import com.weatherforecast.weatherapi.config.WeatherApiProperties;
import com.weatherforecast.weatherapi.dto.CityWeatherForecastDto;
import com.weatherforecast.weatherapi.dto.ForecastDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {

    @Mock
    private WeatherClient weatherClient;

    @Mock
    private WeatherApiProperties properties;

    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        weatherService = new WeatherService(weatherClient, properties);
    }

    @Test
    void testGetForecastForCities() {
        List<String> cities = Arrays.asList("Warsaw", "Krakow");
        when(properties.getCities()).thenReturn(cities);
        when(properties.getApiKey()).thenReturn("test-api-key");

        CityWeatherForecastDto warsawForecast = new CityWeatherForecastDto();
        warsawForecast.setCity("Warsaw");
        warsawForecast.setForecast(new ForecastDto());

        CityWeatherForecastDto krakowForecast = new CityWeatherForecastDto();
        krakowForecast.setCity("Krakow");
        krakowForecast.setForecast(new ForecastDto());

        when(weatherClient.getWeatherForecast(anyString(), eq("Warsaw"), anyInt()))
                .thenReturn(warsawForecast);
        when(weatherClient.getWeatherForecast(anyString(), eq("Krakow"), anyInt()))
                .thenReturn(krakowForecast);

        List<CityWeatherForecastDto> forecasts = weatherService.getForecastForCities();

        assertEquals(2, forecasts.size());
        assertEquals("Warsaw", forecasts.get(0).getCity());
        assertEquals("Krakow", forecasts.get(1).getCity());

        verify(weatherClient, times(1)).getWeatherForecast(anyString(), eq("Warsaw"), anyInt());
        verify(weatherClient, times(1)).getWeatherForecast(anyString(), eq("Krakow"), anyInt());
    }
}
