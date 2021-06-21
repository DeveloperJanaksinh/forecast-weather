package com.mahida.weather.apis.forcastweather.junit.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;


class HourlyApiControllerTest {


    @Test
    void whenZipCode_hourly24hourGet_OK() {

        HourlyApiController api = new HourlyApiController();
        assertEquals(HttpStatus.OK, api.hourly24hourGet(85085).getStatusCode());
        //hourlyApiController.hourly24hourGet(85085);
    }

    @Test
    void whenZipCode_null_hourly24hourGet_Error(){
        HourlyApiController api = new HourlyApiController();
        assertEquals(HttpStatus.BAD_REQUEST, api.hourly24hourGet(null).getStatusCode());
    }

    @Test
    void whenZipCode_getColdest_OK() {
        HourlyApiController api = new HourlyApiController();
        assertEquals(HttpStatus.OK,api.getColdest(85085).getStatusCode());
    }

    @Test
    void whenZipCode_null_getColdest_Error() {
        HourlyApiController api = new HourlyApiController();
        assertEquals(HttpStatus.BAD_REQUEST, api.getColdest(null).getStatusCode());
    }
}