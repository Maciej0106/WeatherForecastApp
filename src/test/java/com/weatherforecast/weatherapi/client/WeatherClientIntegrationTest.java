package com.weatherforecast.weatherapi.client;

import com.weatherforecast.weatherapi.config.WeatherApiProperties;
import com.weatherforecast.weatherapi.dto.CityWeatherForecastDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(components = {WeatherClient.class, WeatherApiProperties.class})
@EnableFeignClients(clients = WeatherClient.class)
public class WeatherClientIntegrationTest {

    @Autowired
    private WeatherClient weatherClient;

    @MockBean
    private WeatherApiProperties weatherApiProperties;

    @Autowired
    private MockRestServiceServer server;

    @Test
    void testGetWeatherForecast() {
        when(weatherApiProperties.getApiKey()).thenReturn("test-api-key");

        String responseJson = "{\"city\":\"Warsaw\",\"forecast\":{\"forecastday\":[{\"date\":\"2023-06-12\",\"day\":{\"maxtemp_c\":25.0,\"mintemp_c\":15.0,\"avgtemp_c\":20.0,\"maxwind_kph\":10.0,\"totalprecip_mm\":5.0,\"totalsnow_cm\":0.0,\"avghumidity\":70,\"avgvis_km\":10.0,\"uv\":5.0}}]}}";

        this.server.expect(requestTo("https://api.weatherapi.com/v1/forecast.json?key=test-api-key&q=Warsaw&days=3"))
                .andRespond(withSuccess(responseJson, MediaType.APPLICATION_JSON));

        CityWeatherForecastDto forecast = weatherClient.getWeatherForecast("test-api-key", "Warsaw", 3);

        assertThat(forecast.getCity()).isEqualTo("Warsaw");
        assertThat(forecast.getForecast().getForecastDay()).hasSize(1);
        assertThat(forecast.getForecast().getForecastDay().get(0).getDay().getMaxTempC()).isEqualTo(25.0);
    }
}
