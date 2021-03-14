package com.example.demo.Model.City;

public class CityModel {
    private String cityZipCode;
    private String cityName;

    public CityModel() {
    }

    public CityModel(String cityZipCode, String cityName) {
        this.cityZipCode = cityZipCode;
        this.cityName = cityName;
    }

    public void setCityZipCode(String cityZipCode) {
        this.cityZipCode = cityZipCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityZipCode() {
        return cityZipCode;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return String.format("City with the zipcode: %s, is: %s", cityZipCode, cityName);
    }
}