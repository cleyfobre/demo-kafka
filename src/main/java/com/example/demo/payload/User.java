package com.example.demo.payload;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private int id;
    private String firstName;
    private String lastName;

}
