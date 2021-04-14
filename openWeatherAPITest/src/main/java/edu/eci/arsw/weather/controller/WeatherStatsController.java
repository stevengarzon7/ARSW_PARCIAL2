
 package edu.eci.arsw.weather.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.model.City;
import edu.eci.arsw.weather.services.WeatherStatServicesI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("v1")
public class WeatherStatsController {

    /**
     * The Weather services.
     */
    @Autowired
    WeatherStatServicesI weatherStatServices;

    /**
     * Gets all cases.
     *
     * @param place the place
     * @return the all cases
     */
    @GetMapping()
    public ResponseEntity<?> getAllCases(@RequestParam String place) {
        City city = null;
        try {
            city = weatherStatServices.getStatsByCity(place);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }
}