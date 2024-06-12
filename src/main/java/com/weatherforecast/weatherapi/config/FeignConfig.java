package com.weatherforecast.weatherapi.config;

import com.weatherforecast.weatherapi.exception.CityNotFoundException;
import com.weatherforecast.weatherapi.exception.ExternalServiceInvocationException;
import com.weatherforecast.weatherapi.exception.InvalidApiKeyException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    public static class CustomErrorDecoder implements ErrorDecoder {

        private final ErrorDecoder defaultErrorDecoder = new Default();

        @Override
        public Exception decode(String methodKey, Response response) {
            String reason = response.reason();
            switch (response.status()) {
                case 400:
                    return new InvalidApiKeyException("Invalid API key: " + reason, response.request().headers().toString());
                case 404:
                    return new CityNotFoundException("City not found: " + reason, extractCityFromRequest(response.request().url()));
                case 500:
                    return new ExternalServiceInvocationException("Internal server error: " + reason, response.request().url());
                default:
                    return defaultErrorDecoder.decode(methodKey, response);
            }
        }

        private String extractCityFromRequest(String url) {

            String city = null;
            try {
                city = java.net.URLDecoder.decode(url.split("q=")[1].split("&")[0], "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return city;
        }
    }
}

