package com.example.resttemplate.model;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {
    private boolean error;
    private String msg;
    private List<Countries> data;
}
