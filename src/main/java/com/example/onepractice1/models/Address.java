package com.example.onepractice1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private Long id;
    private String landmark;
    private String city;
    private String street;
    private int houseNumber;
    private int flatNumber;

}
