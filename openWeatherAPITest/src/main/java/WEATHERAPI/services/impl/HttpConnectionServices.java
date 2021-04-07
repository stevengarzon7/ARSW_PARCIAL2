/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEATHERAPI.services.impl;

/**
 *
 * @author imac
 */
import WEATHERAPI.services.HttpConnectionServicesI;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HttpConnectionServices implements HttpConnectionServicesI {

    @Override
    public JSONObject getAllWeathers() throws UnirestException {
                 HttpResponse<String> respuesta = null;
       
            respuesta = Unirest.get("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=55f42aa7100c6f035056aae2b29c54ae").asString();
            return new JSONObject(respuesta.getBody());
    }

    @Override
    public JSONObject getWeatherByCity(String city) throws UnirestException {
        HttpResponse<String> respuesta = null;
        
            respuesta = Unirest.get("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=55f42aa7100c6f035056aae2b29c54ae").asString();
            return new JSONObject(respuesta.getBody());
    }

    @Override
    public JSONArray getLocationCountry(String place) throws UnirestException {
        
        if (place.equals("US")) place = "USA";
         HttpResponse<String> response = null;
        response =Unirest.get("https://api.openweathermap.org/data/2.5/weather?q=" + place + "&appid=55f42aa7100c6f035056aae2b29c54ae").asString();
                
               
        if (response.getBody().contains("404")) {
            return new JSONArray();
        }
        return new JSONArray(response.getBody()).getJSONObject(0).getJSONArray("latlng");
    }
}
