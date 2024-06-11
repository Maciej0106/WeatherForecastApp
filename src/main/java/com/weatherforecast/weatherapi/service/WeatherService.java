package com.weatherforecast.weatherapi.service;

import com.weatherforecast.weatherapi.client.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {
    @Autowired
    private WeatherClient weatherClient;

    private ObjectMapper mapper = new ObjectMapper();

    public String getForecastForCities() {
        String[] cities = {"Warsaw", "Krakow", "Lodz", "Wroclaw", "Poznan"};
        StringBuilder results = new StringBuilder();
        for (String city : cities) {
            String response = weatherClient.getWeatherForecast(System.getenv("WEATHERAPI_API_KEY"), city, 3);
            String parsedData = parseWeatherData(response, city);
            results.append(parsedData).append("\n\n---\n\n");
        }
        return results.toString();
    }

    private String parseWeatherData(String jsonData, String city) {
        try {
            JsonNode root = mapper.readTree(jsonData);
            JsonNode forecastDays = root.path("forecast").path("forecastday");
            StringBuilder sb = new StringBuilder();

            sb.append("\nCity: ").append(city).append("\n");

            for (JsonNode dayNode : forecastDays) {
                String date = dayNode.path("date").asText();
                double maxTemp = dayNode.path("day").path("maxtemp_c").asDouble();
                double minTemp = dayNode.path("day").path("mintemp_c").asDouble();
                double avgTemp = dayNode.path("day").path("avgtemp_c").asDouble();
                double maxWind = dayNode.path("day").path("maxwind_kph").asDouble();
                double totalPrecip = dayNode.path("day").path("totalprecip_mm").asDouble();
                double snow = dayNode.path("day").path("snow_cm").asDouble();
                int humidity = dayNode.path("day").path("avghumidity").asInt();
                double visibility = dayNode.path("day").path("avgvis_km").asDouble();
                double uv = dayNode.path("day").path("uv").asDouble();

                sb.append(String.format("  Date: %s\n", date));
                sb.append(String.format("    Max Temp: %.1f°C\n", maxTemp));
                sb.append(String.format("    Min Temp: %.1f°C\n", minTemp));
                sb.append(String.format("    Avg Temp: %.1f°C\n", avgTemp));
                sb.append(String.format("    Max Wind: %.1f km/h\n", maxWind));
                sb.append(String.format("    Precipitation: %.2f mm\n", totalPrecip));
                sb.append(String.format("    Snow: %.1f cm\n", snow));
                sb.append(String.format("    Humidity: %d%%\n", humidity));
                sb.append(String.format("    Visibility: %.1f km\n", visibility));
                sb.append(String.format("    UV Index: %.1f\n", uv));
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing weather data for " + city;
        }
    }
}
