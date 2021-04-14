package edu.eci.arsw.weather.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.model.City;

/**
 * The interface Weather services i.
 */
public interface WeatherStatServicesI {
    /**
     * Gets stats by city.
     *
     * @param city the city
     * @return the stats by city
     * @throws UnirestException the unirest exception
     */
    City getStatsByCity(String city) throws UnirestException;
}