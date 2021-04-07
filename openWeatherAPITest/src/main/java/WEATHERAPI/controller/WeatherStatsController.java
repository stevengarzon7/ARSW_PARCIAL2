/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEATHERAPI.controller;

/**
 *
 * @author imac
 */

import WEATHERAPI.model.Case;
import WEATHERAPI.model.Country;
import WEATHERAPI.services.WeatherStatServicesI;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("v1")
public class WeatherStatsController {

    @Autowired
    WeatherStatServicesI weatherStatServices;

    @GetMapping()
    public ResponseEntity<?> getAllCases() {
        List<Country> cases;
        try {
            cases = weatherStatServices.getAllWeathers();
        } catch (UnirestException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Country>>(cases, HttpStatus.OK);
    }

    @GetMapping("stats")
    public ResponseEntity<?> getCasesByCountry(@RequestParam String country) {
        Country cases = null;
        try {
            cases = weatherStatServices.getWeatherByCountry(country);
        } catch (UnirestException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Country>(cases, HttpStatus.OK);
    }
}
