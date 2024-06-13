package com.weatherforecast.weatherapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "weatherapi")
@Getter
@Setter
public class WeatherApiProperties {
    private String apiKey;
    private List<String> cities;
}
