package com.example.resttemplate.service.serviseImp;

import com.example.resttemplate.model.City;
import com.example.resttemplate.model.Countries;
import com.example.resttemplate.model.DataResponse;
import com.example.resttemplate.model.StateCapitalPair;
import com.example.resttemplate.service.CityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public CityServiceImpl() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<Countries> getCountryDetails() {
        String uri = "https://countriesnow.space/api/v0.1/countries";
        Object[] objects = new Object[]{restTemplate.getForObject(uri, Object.class)};
        List<Countries> countries = Arrays.stream(objects)
                .map(o -> objectMapper.convertValue(o, DataResponse.class))
                .map(DataResponse::getData)
                .collect(Collectors.toList())
                .get(0);
        return countries;
    }

    @Override
    public List<City> getCitiesInNigeria() {
        List<Countries> countries = getCountryDetails();
        return countries.stream()
                .filter(country -> "Nigeria".equalsIgnoreCase(country.getCountry()))
                .findFirst()
                .map(Countries::getCities)
                .orElse(Collections.emptyList());
    }

    @Override
    public List<StateCapitalPair> getStatesAndCapitalsInNigeria() {
        List<Countries> countries = getCountryDetails();
        return countries.stream()
                .filter(country -> "Nigeria".equalsIgnoreCase(country.getCountry()))
                .findFirst()
                .map(Countries::getStates)
                .orElse(Collections.emptyList());
    }

    @Override
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

    @Override
    public List<City> getCitiesInEnugu() {
        List<Countries> countries = getCountryDetails();
        return countries.stream()
                .filter(country -> "Nigeria".equalsIgnoreCase(country.getCountry()))
                .findFirst()
                .map(Countries::getCities)
                .orElse(Collections.emptyList())
                .stream()
                .filter(city -> "Enugu".equalsIgnoreCase(city.getCity()))
                .collect(Collectors.toList());
    }
}
