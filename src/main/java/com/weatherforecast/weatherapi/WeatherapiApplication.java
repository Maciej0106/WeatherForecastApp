package com.weatherforecast.weatherapi;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherapiApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();

		String apiKey = dotenv.get("WEATHER_API_KEY");
		if (apiKey != null && !apiKey.isEmpty()) {
			System.setProperty("WEATHER_API_KEY", apiKey);
			System.out.println("WEATHER_API_KEY is set.");
		} else {
			System.out.println("WEATHER_API_KEY is not set or is empty.");
		}

		SpringApplication.run(WeatherapiApplication.class, args);
	}
}
