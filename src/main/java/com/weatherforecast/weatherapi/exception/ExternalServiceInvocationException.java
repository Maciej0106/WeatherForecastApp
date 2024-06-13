package com.weatherforecast.weatherapi.exception;

import lombok.Getter;

@Getter
public class ExternalServiceInvocationException extends RuntimeException {
    private final String serviceName;

    public ExternalServiceInvocationException(String message, String serviceName) {
        super(message);
        this.serviceName = serviceName;
    }

    public ExternalServiceInvocationException(String message, String serviceName, Throwable cause) {
        super(message, cause);
        this.serviceName = serviceName;
    }
}
