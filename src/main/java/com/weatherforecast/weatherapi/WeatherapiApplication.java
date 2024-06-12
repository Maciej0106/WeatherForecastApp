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

		System.setProperty("API_KEY", dotenv.get("API_KEY"));
		SpringApplication.run(WeatherapiApplication.class, args);
	}
}

