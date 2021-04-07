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
         String url = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=55f42aa7100c6f035056aae2b29c54ae";
        
        HttpResponse<String> response = Unirest
                .get(url)
                
                .asString();
        return new JSONObject(response.getBody()).getJSONObject("data");
    }

    @Override
    public JSONObject getWeatherByCountry(String country) throws UnirestException {
         String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=55f42aa7100c6f035056aae2b29c54ae", country);
        HttpResponse<String> response = Unirest
                
                .get(url)
               
                .asString();
        return new JSONObject(response.getBody()).getJSONObject("data");
    }

    @Override
    public JSONArray getLocationCountry(String place) throws UnirestException {
         String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=55f42aa7100c6f035056aae2b29c54ae", place);
        if (place.equals("US")) place = "USA";
        HttpResponse<String> response = Unirest.get(url)
                
                .asString();
        if (response.getBody().contains("404")) {
            return new JSONArray();
        }
        return new JSONArray(response.getBody()).getJSONObject(0).getJSONArray("latlng");
    }
}
