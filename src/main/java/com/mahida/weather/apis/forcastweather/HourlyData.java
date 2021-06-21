package com.mahida.weather.apis.forcastweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HourlyData {

    @JsonProperty("hour")
    private String hour;
    @JsonProperty("temperature")
    private String temperature;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public HourlyData(String hour, String temperature) {
        this.hour = hour;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "HourlyData{" +
                "hour='" + hour + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
