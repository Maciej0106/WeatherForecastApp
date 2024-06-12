package com.weatherforecast.weatherapi.controller;

import com.weatherforecast.weatherapi.dto.CityWeatherForecastDto;
import com.weatherforecast.weatherapi.dto.ForecastDto;
import com.weatherforecast.weatherapi.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class WeatherControllerTest {

    private MockMvc mockMvc;

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();
    }

    @Test
    void testGetWeatherForecast() throws Exception {
        CityWeatherForecastDto warsawForecast = new CityWeatherForecastDto();
        warsawForecast.setCity("Warsaw");
        warsawForecast.setForecast(new ForecastDto());

        CityWeatherForecastDto krakowForecast = new CityWeatherForecastDto();
        krakowForecast.setCity("Krakow");
        krakowForecast.setForecast(new ForecastDto());

        when(weatherService.getForecastForCities()).thenReturn(Arrays.asList(warsawForecast, krakowForecast));

        mockMvc.perform(get("/api/weather/forecast")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].city").value("Warsaw"))
                .andExpect(jsonPath("$[1].city").value("Krakow"));
    }
}

