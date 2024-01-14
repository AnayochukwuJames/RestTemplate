package com.example.resttemplate.controller;

import com.example.resttemplate.model.City;
import com.example.resttemplate.model.Countries;
import com.example.resttemplate.model.DataResponse;
import com.example.resttemplate.model.StateCapitalPair;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CityController {
    @GetMapping("cities")
    public List<Countries> getCountryDetails (){
        List<Countries> countries = new ArrayList<>();

        String uri = "https://countriesnow.space/api/v0.1/countries";
        RestTemplate template = new RestTemplate();
        Object[] objects = new Object[]{template.getForObject(uri, Object.class)};
        ObjectMapper objectMapper = new ObjectMapper();
         countries = Arrays.stream(objects).map(o -> objectMapper.convertValue(o, DataResponse.class))
                .map(DataResponse :: getData)
                .collect(Collectors.toList()).get(0);
        return countries;
    }

    @GetMapping("cities/nigeria")
    public List<City> getCitiesInNigeria() {
        List<Countries> countries = getCountryDetails();
        return countries.stream()
                .filter(country -> "Nigeria".equalsIgnoreCase(country.getCountry()))
                .findFirst()
                .map(Countries::getCities)
                .orElse(Collections.emptyList());
    }
    @GetMapping("state/nigeria")
    public List<StateCapitalPair> getStatesAndCapitalsInNigeria() {
        List<Countries> countries = getCountryDetails();

        countries.forEach(country -> {
            System.out.println("Country: " + country.getCountry());
            System.out.println("States: " + country.getStates());
        });

        return countries.stream()
                .filter(country -> "Nigeria".equalsIgnoreCase(country.getCountry()))
                .findFirst()
                .map(Countries::getStates)
                .orElse(Collections.emptyList());
    }
    @GetMapping("cities/lagos")
    public List<City> getCitiesInLagos() {
        List<Countries> countries = getCountryDetails();
        return countries.stream()
                .filter(country -> "Nigeria".equalsIgnoreCase(country.getCountry()))
                .findFirst()
                .map(Countries::getCities)
                .orElse(Collections.emptyList())
                .stream()
                .filter(city -> "Lagos".equalsIgnoreCase(city.getCity()))
                .collect(Collectors.toList());
    }


}
