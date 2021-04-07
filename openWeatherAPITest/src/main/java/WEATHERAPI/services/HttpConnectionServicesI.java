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


import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public interface HttpConnectionServicesI {
    JSONObject getAllWeathers() throws UnirestException;

    JSONObject getWeatherByCountry(String country) throws UnirestException;

    JSONArray getLocationCountry(String country) throws UnirestException;
}