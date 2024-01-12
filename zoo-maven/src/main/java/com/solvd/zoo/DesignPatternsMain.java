package com.solvd.zoo;

import com.solvd.zoo.model.Address;
import com.solvd.zoo.model.enums.Factory;
import com.solvd.zoo.patterns.AbstractFactory;
import com.solvd.zoo.patterns.Zoo;
import com.solvd.zoo.patterns.observer.MarketingDepartment;
import com.solvd.zoo.patterns.observer.Tv;
import com.solvd.zoo.patterns.observer.WebPage;

import java.util.List;

public class DesignPatternsMain {
    public static void main(String[] args) {
        //-Abstract factory
        //-Factory
        //-Builder
        //-Observer

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


        MarketingDepartment marketingDepartment = new MarketingDepartment();
        marketingDepartment.addObserver((s)-> System.out.println(s + " from lambda"));
        marketingDepartment.addObserver(new Tv());
        marketingDepartment.addObserver(new WebPage());
        marketingDepartment.setNews("Hello");


    }
}
