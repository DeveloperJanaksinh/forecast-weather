package com.mahida.weather.apis.forcastweather.controller;

import com.mahida.weather.apis.forcastweather.HourlyData;
import com.mahida.weather.apis.forcastweather.HourlyResponse;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@RestController
@Validated
@RequestMapping(path = "/forecast/v1")
public class HourlyApiController {

    private static final Logger log = LoggerFactory.getLogger(HourlyApiController.class);

    @RequestMapping(method = RequestMethod.GET, path = "/hourly/24hour")
    public ResponseEntity<Object> hourly24hourGet(@RequestParam Integer zipcode) {

        log.info("entry : hourly24hourGet  <UUID>");

        try {
            if(zipcode != null) {
                HourlyResponse hourly = getHourlyData();
                return new ResponseEntity<>(hourly, HttpStatus.OK);
            } else {
                log.info("error : invalid zipcode for  <UUID>");
                return new ResponseEntity<>("Invalid ZipCode", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.info("exception occurred for <UUID> "+e.getMessage());
            return new ResponseEntity<>("Error Occurred, please reach out to ops team", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hourly/24hour/coldest")
    public ResponseEntity<Object> getColdest(@RequestParam Integer zipcode) {

        log.info("entry : getColdest  <UUID>");

        try{
            if(zipcode != null) {
                HourlyResponse hourly = getHourlyData();
                return new ResponseEntity<>(getColdestHour(hourly.getHourly()).getHour(), HttpStatus.OK);
            } else {
                log.info("error : invalid zipcode for  <UUID>");
                return new ResponseEntity<>("Invalid ZipCode", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.info("exception occurred for <UUID> "+e.getMessage());
            return new ResponseEntity<>("Error Occurred, please reach out to ops team", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @NotNull
    private HourlyResponse getHourlyData() throws Exception{
        HourlyResponse hr = new HourlyResponse();
        hr.setDateTime(LocalDate.now().toString());
        hr.setUnit("Fahrenheit");
        List<HourlyData> hourly = new ArrayList<>();
        HourlyData hd = new HourlyData("00", "78");
        HourlyData hd1 = new HourlyData("01", "77");
        HourlyData hd2 = new HourlyData("02", "76");
        HourlyData hd23 = new HourlyData("23", "70");
        hourly.add(hd);
        hourly.add(hd1);
        hourly.add(hd2);
        hourly.add(hd23);
        hr.setHourly(hourly);
        return hr;
    }


    public HourlyData getColdestHour(List<HourlyData> list) throws Exception {

        HourlyData strmHd = Collections.min(list, Comparator.comparing(s -> s.getTemperature()));
        return strmHd;

    }

}
