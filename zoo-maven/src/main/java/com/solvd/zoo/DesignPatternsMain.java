package com.solvd.zoo;

import com.solvd.zoo.model.Address;
import com.solvd.zoo.model.enums.Factory;
import com.solvd.zoo.patterns.AbstractFactory;
import com.solvd.zoo.patterns.Zoo;

import java.util.List;

public class DesignPatternsMain {
    public static void main(String[] args) {
        //-Abstract factory
        //-Factory
        //Builder

        AbstractFactory
                .getFactory(Factory.MYSQL)
                .getDaoImplementation("employee")
                .getEntities()
                .forEach(System.out::println);

        AbstractFactory
                .getFactory(Factory.MYBATIS)
                .getDaoImplementation("employee")
                .getEntities()
                .forEach(System.out::println);

        Zoo zoo = Zoo.builder()
                .id(1L)
                .address(new Address())
                .events(List.of())
                .employees(List.of())
                .visitors(List.of())
                .name("The zoo")
                .build();
        System.out.println(zoo);


    }
}
