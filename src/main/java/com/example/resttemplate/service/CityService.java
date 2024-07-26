package com.example.resttemplate.service;

import com.example.resttemplate.model.City;
import com.example.resttemplate.model.Countries;
import com.example.resttemplate.model.StateCapitalPair;

import java.util.List;

public interface CityService {
    List<Countries> getCountryDetails();
    List<City> getCitiesInNigeria();
    List<StateCapitalPair> getStatesAndCapitalsInNigeria();
    List<City> getCitiesInLagos();
    List<City> getCitiesInEnugu();
}
