/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEATHERAPI.model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class World {
    private List<City> countries = new ArrayList<>();

    public List<City> getCountries() {
        return countries;
    }

    public void setCountries(List<City> countries) {
        this.countries = countries;
    }

    public void addCountry(City country) {
        this.countries.add(country);
    }



}