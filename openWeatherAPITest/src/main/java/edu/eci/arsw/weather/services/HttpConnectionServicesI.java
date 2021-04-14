/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.weather.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

/**
 * The interface Http connection services i.
 */
public interface HttpConnectionServicesI {
    /**
     * Gets stats city.
     *
     * @param city the city
     * @return the stats city
     * @throws UnirestException the unirest exception
     */
    JSONObject getStatsCity(String city) throws UnirestException;
}