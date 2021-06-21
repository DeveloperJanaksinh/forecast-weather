package com.mahida.weather.apis.forcastweather.integration;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@SpringBootTest
public class HourlyApiControllerTestIT {

    @Test
    public void getHourlyForcastTest() throws JSONException {

        String date = LocalDate.now().toString();
        String expectedOutputStr = "{\n" +
                "    \"date_time\": \""+date+"\",\n" +
                "    \"unit\": \"Fahrenheit\",\n" +
                "    \"details\": [\n" +
                "        {\n" +
                "            \"hour\": \"00\",\n" +
                "            \"temperature\": \"78\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"hour\": \"01\",\n" +
                "            \"temperature\": \"77\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"hour\": \"02\",\n" +
                "            \"temperature\": \"76\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"hour\": \"23\",\n" +
                "            \"temperature\": \"70\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String>  res= restTemplate.getForEntity(
                "http://localhost:8080/forecast/v1/hourly/24hour?zipcode=85085", String.class);

        System.out.println("Response status code" +res.getStatusCode());
        System.out.println("Response body" +res.getBody());

        JSONAssert.assertEquals(expectedOutputStr, res.getBody(),false);
    }


    @Test
    public void getColdestest() throws JSONException {

        String expectedOutputStr = "23";

        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String>  res= restTemplate.getForEntity(
                "http://localhost:8080/forecast/v1/hourly/24hour/coldest?zipcode=85085", String.class);

        System.out.println("Response status code" +res.getStatusCode());
        System.out.println("Response body" +res.getBody());

        JSONAssert.assertEquals(expectedOutputStr, res.getBody(),false);
    }


}
