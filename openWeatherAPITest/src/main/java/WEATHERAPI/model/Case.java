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
public class Case {
    private String city;
    private String province;
    private String country;
    private String keyId;
    private Integer temperature;
    private Integer humidity;
    private Integer visibility;

    public Case(Object city, Object province, String country, String keyId, Integer visibility, Integer humidity, Integer temperature) {
        this.city = ((city == null) ? "" : (String) city);
        this.province = ((city == null) ? "" : (String) province);
        this.country = country;
        this.keyId = keyId;
        this.visibility = visibility;
        this.humidity = humidity;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = ((city == null) ? "" : city);
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = ((province == null) ? "" : province);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
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
}

 