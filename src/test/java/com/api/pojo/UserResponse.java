package com.api.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
}
