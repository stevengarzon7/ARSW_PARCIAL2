/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEATHERAPI.services;

/**
 *
 * @author imac
 */
import WEATHERAPI.model.City;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.*;

public interface WeatherStatServicesI {
    List<City> getAllWeathers() throws UnirestException;

    City getWeatherByCity(String country) throws UnirestException;
}
