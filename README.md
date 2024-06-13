## Overview

This project is a Spring Boot application that fetches weather forecasts for multiple cities using the WeatherAPI. It leverages Spring Cloud OpenFeign to interact with the WeatherAPI and handles various exceptions gracefully.

## Prerequisites

- Java 21
- Maven 3.6+
- WeatherAPI Key

## Installation

1. Clone this repository to your local machine.
2. Navigate to the project directory

## Configuration
The application uses properties defined in application.properties and WeatherApiProperties class for configuration. Make sure to set your WeatherAPI key and the cities for which you want to fetch the forecast.
Create a .env file in the root directory of your project to store your API key
*WEATHER_API_KEY=your_weather_api_key*


## Running the Application
*To run the application, use the following command*:
mvn spring-boot:run


## Endpoints

*Fetch Weather Forecast*:
- URL: /api/weather/forecast
- Method: GET
- Description: Fetches weather forecasts for the configured cities.
- Response: A list of weather forecasts for the next 3 days for each city.

*Swagger UI*:
- URL: /swagger-ui.html
- Description: Provides a visual interface to interact with the API and explore the available endpoints.

*OpenAPI Documentation*:
- URL: /v3/api-docs
- Description: Provides the OpenAPI documentation for the API.
