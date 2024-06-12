package com.weatherforecast.weatherapi.exception;

public class CityNotFoundException extends RuntimeException {
    private final String cityName;

    public CityNotFoundException(String message, String cityName) {
        super(message);
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}
