/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEATHERAPI.model;

/**
 *
 * @author imac
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Country implements Comparable<Country> {
    private String name;
    private int humidity = 0;
    private int visibility = 0;
    private int temperature = 0;
    private Location location = new Location(0, 0);
    private List<Province> provinces = new ArrayList<>();

    public Country(String name, int num_deaths, int num_infected, int num_cured, Location location) {
        this.name = name;
        this.humidity = num_deaths;
        this.visibility = num_infected;
        this.temperature = num_cured;
        this.location = location;
    }

    public Country() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void addProvince(Province province) {
        this.provinces.add(province);
    }

    @Override
    public int compareTo(Country o) {
        int result = Comparator.comparing(Country::getTemperature).reversed()
                .thenComparing(Country::getVisibility).reversed()
                .thenComparing(Country::getHumidity).reversed().compare(this, o);
        return result;
    }
}