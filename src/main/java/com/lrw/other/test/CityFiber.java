package com.lrw.other.test;

import java.util.List;

//城市之间关系
public class CityFiber {

   City city;
   List<City> cityList ;

    public CityFiber(City city, List<City> cityList) {
        this.city = city;
        this.cityList = cityList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
