package com.weatherforecast.weatherapi.exception;

public class InvalidApiKeyException extends RuntimeException {
    private final String apiKey;

    public InvalidApiKeyException(String message, String apiKey) {
        super(message);
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }
}
