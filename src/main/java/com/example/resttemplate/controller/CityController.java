package com.example.resttemplate.controller;

import com.example.resttemplate.model.Countries;
import com.example.resttemplate.model.DataResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
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
//    @GetMapping("city")
//    public List<Countries> getCity() {
//        System.out.println("I am here");
//        return countries.stream().filter(e -> getCountry().equals("Nigeria")).collect(Collectors.toList());
//    }
//    private String getCountry() {
//        return "Nigeria";
//    }
//    public List<Countries> getCity(){
//        System.out.println("I am here");
//        return countries.stream().filter(e-> getCountry().equals("Nigeria")).collect(Collectors.toList());
//    }
}
