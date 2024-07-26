package com.example.resttemplate.controller;

import com.example.resttemplate.model.City;
import com.example.resttemplate.model.Countries;
import com.example.resttemplate.model.StateCapitalPair;
import com.example.resttemplate.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("cities")
    public List<Countries> getCountryDetails() {
        return cityService.getCountryDetails();
    }

    @GetMapping("cities/nigeria")
    public List<City> getCitiesInNigeria() {
        return cityService.getCitiesInNigeria();
    }

    @GetMapping("state/nigeria")
    public List<StateCapitalPair> getStatesAndCapitalsInNigeria() {
        return cityService.getStatesAndCapitalsInNigeria();
    }

    @GetMapping("cities/lagos")
    public List<City> getCitiesInLagos() {
        return cityService.getCitiesInLagos();
    }

    @GetMapping("cities/enugu")
    public List<City> getCitiesInEnugu() {
        return cityService.getCitiesInEnugu();
    }
}
