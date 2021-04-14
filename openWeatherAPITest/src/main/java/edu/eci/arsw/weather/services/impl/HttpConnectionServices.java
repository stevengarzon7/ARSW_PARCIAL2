package edu.eci.arsw.weather.services.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.services.HttpConnectionServicesI;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * The type Http connection services.
 */
@Service
public class HttpConnectionServices implements HttpConnectionServicesI {
    @Override
    public JSONObject getStatsCity(String place) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://api.openweathermap.org/data/2.5/weather?q=" + place + "&appid=55f42aa7100c6f035056aae2b29c54ae")
                .asString();
        System.out.println("CONSULTA!");
        return new JSONObject(response.getBody());
    }
}




