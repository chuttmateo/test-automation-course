package com.solvd.zoo.patterns;

import com.solvd.zoo.model.Address;

import java.util.List;

public class Facade {
    public Zoo createASampleZoo(){
        Zoo zoo = Zoo.builder()
                .id(1L)
                .address(new Address())
                .events(List.of())
                .employees(List.of())
                .visitors(List.of())
                .name("The zoo")
                .build();
        return zoo;
    }
}
