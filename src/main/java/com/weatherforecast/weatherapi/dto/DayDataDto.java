package com.weatherforecast.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayDataDto {
    @JsonProperty("maxtemp_c")
    private double maxTempC;

    @JsonProperty("mintemp_c")
    private double minTempC;

    @JsonProperty("avgtemp_c")
    private double avgTempC;

    @JsonProperty("maxwind_kph")
    private double maxWindKph;

    @JsonProperty("totalprecip_mm")
    private double totalPrecipMm;

    @JsonProperty("totalsnow_cm")
    private double totalSnowCm;

    @JsonProperty("avghumidity")
    private int avgHumidity;

    @JsonProperty("avgvis_km")
    private double avgVisKm;

    @JsonProperty("uv")
    private double uv;


    public double getMaxTempC() {
        return maxTempC;
    }

    public void setMaxTempC(double maxTempC) {
        this.maxTempC = maxTempC;
    }

    public double getMinTempC() {
        return minTempC;
    }

    public void setMinTempC(double minTempC) {
        this.minTempC = minTempC;
    }

    public double getAvgTempC() {
        return avgTempC;
    }

    public void setAvgTempC(double avgTempC) {
        this.avgTempC = avgTempC;
    }

    public double getMaxWindKph() {
        return maxWindKph;
    }

    public void setMaxWindKph(double maxWindKph) {
        this.maxWindKph = maxWindKph;
    }

    public double getTotalPrecipMm() {
        return totalPrecipMm;
    }

    public void setTotalPrecipMm(double totalPrecipMm) {
        this.totalPrecipMm = totalPrecipMm;
    }

    public double getTotalSnowCm() {
        return totalSnowCm;
    }

    public void setTotalSnowCm(double totalSnowCm) {
        this.totalSnowCm = totalSnowCm;
    }

    public int getAvgHumidity() {
        return avgHumidity;
    }

    public void setAvgHumidity(int avgHumidity) {
        this.avgHumidity = avgHumidity;
    }

    public double getAvgVisKm() {
        return avgVisKm;
    }

    public void setAvgVisKm(double avgVisKm) {
        this.avgVisKm = avgVisKm;
    }

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }
}

