package com.example.resttemplate.model;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Countries {
private String iso2;
private String iso3;
private String Country;
private List<City> cities;
private List<StateCapitalPair> states;

}
