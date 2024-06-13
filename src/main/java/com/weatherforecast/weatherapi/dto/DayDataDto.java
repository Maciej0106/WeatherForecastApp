package com.weatherforecast.weatherapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DayDataDto {
    private double maxtemp_c;
    private double mintemp_c;
    private double avgtemp_c;
    private double maxwind_kph;
    private double totalprecip_mm;
    private double totalsnow_cm;
    private int avghumidity;
    private double avgvis_km;
    private double uv;
}
