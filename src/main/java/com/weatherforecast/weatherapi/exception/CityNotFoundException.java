package com.weatherforecast.weatherapi.exception;

import lombok.Getter;

@Getter
public class CityNotFoundException extends RuntimeException {
    private final String cityName;

    public CityNotFoundException(String message, String cityName) {
        super(message);
        this.cityName = cityName;
    }
}
