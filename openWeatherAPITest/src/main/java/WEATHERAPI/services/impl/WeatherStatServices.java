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
import WEATHERAPI.model.*;
import WEATHERAPI.services.*;
import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class WeatherStatServices implements WeatherStatServicesI {
    @Autowired
    HttpConnectionServicesI httpConnectionService;

    @Override
    public List<City> getAllWeathers() throws UnirestException {
        World world = new World();
        JSONArray jsonArray = httpConnectionService.getAllWeathers().getJSONArray("weatherStats");
        List<Case> cases = getCases(new ArrayList<>(), jsonArray);
        for (Case aCase : cases) {
            if (aCase.getProvince() == null) {
                int temperature = 0;
                temperature = aCase.getTemperature();
                
                world.addCountry(new City(aCase.getCountry(), aCase.getHumidity(), aCase.getVisibility(), temperature, new Location(0, 0)));

            } else {
                City country = new City();
                if (world.getCountries().stream().map(City::getName).noneMatch(aCase.getCountry()::equals)) {
                    AtomicInteger humidity = new AtomicInteger(0);
                    AtomicInteger visibility = new AtomicInteger(0);
                    AtomicInteger temperature = new AtomicInteger(0);
                    country.setName(aCase.getCountry());
                    cases.forEach(country1 -> {
                        int weather = 0;
                        if (country1.getCountry().equals(aCase.getCountry())) {
                            
                            weather = (country1.getTemperature());
                            
                            Province province = new Province(country1.getProvince(), country1.getHumidity(), country1.getVisibility(), weather, country1.getCity());
                            humidity.addAndGet(country1.getHumidity());
                            visibility.addAndGet(country1.getVisibility());
                            temperature.addAndGet(weather);
                            country.addProvince(province);
                        }
                    });
                    country.setTemperature(temperature.get());
                    country.setVisibility(visibility.get());
                    country.setHumidity(humidity.get());
                    world.addCountry(country);
                }
            }
        }
        Collections.sort(world.getCountries());
        return world.getCountries();
    }

    @Override
    public City getWeatherByCity(String country) throws UnirestException {
        List<City> countries = this.getAllWeathers().stream().filter(country1 -> country1.getName().equals(country)).collect(Collectors.toList());
        System.out.println(country);
        countries.forEach(country1 -> {
            JSONArray coords = null;
            try {
                System.out.println(country1.getName());
                coords = httpConnectionService.getLocationCountry(country1.getName());
                System.out.println(coords);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
            assert coords != null;
            country1.setLocation(new Location(coords.getDouble(0), coords.getDouble(1)));
        });
        return countries.get(0);
    }

    private List<Case> getCases(ArrayList<Case> cases, JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Gson gson = new Gson();
            cases.add(gson.fromJson(String.valueOf(jsonObject), Case.class));
        }
        return cases;
    }

}
