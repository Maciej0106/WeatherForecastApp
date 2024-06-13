package com.weatherforecast.weatherapi.exception;

import lombok.Getter;

@Getter
public class InvalidApiKeyException extends RuntimeException {
    private final String apiKey;

    public InvalidApiKeyException(String message, String apiKey) {
        super(message);
        this.apiKey = apiKey;
    }
}
