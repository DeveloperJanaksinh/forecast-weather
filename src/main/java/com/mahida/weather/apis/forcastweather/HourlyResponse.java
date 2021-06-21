package com.mahida.weather.apis.forcastweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HourlyResponse {

    @JsonProperty("date_time")
    private String dateTime;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("details")
    private List<HourlyData> hourly;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<HourlyData> getHourly() {
        return hourly;
    }

    public void setHourly(List<HourlyData> hourly) {
        this.hourly = hourly;
    }

    @Override
    public String toString() {
        return "HourlyResponse{" +
                "dateTime='" + dateTime + '\'' +
                ", unit='" + unit + '\'' +
                ", hourly=" + hourly +
                '}';
    }
}
