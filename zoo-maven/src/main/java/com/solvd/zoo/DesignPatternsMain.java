package com.solvd.zoo;

import com.solvd.zoo.model.Address;
import com.solvd.zoo.model.enums.Factory;
import com.solvd.zoo.patterns.AbstractFactory;
import com.solvd.zoo.patterns.Facade;
import com.solvd.zoo.patterns.Zoo;
import com.solvd.zoo.patterns.decorator.DecoratorBase;
import com.solvd.zoo.patterns.decorator.DecoratorInterface;
import com.solvd.zoo.patterns.decorator.Notifier;
import com.solvd.zoo.patterns.observer.MarketingDepartment;
import com.solvd.zoo.patterns.observer.Tv;
import com.solvd.zoo.patterns.observer.WebPage;
import com.solvd.zoo.patterns.strategy.BubbleSort;
import com.solvd.zoo.patterns.strategy.MergeSort;
import com.solvd.zoo.patterns.strategy.Sorter;
import com.solvd.zoomaven.concurrent.ConnectionPool;

import java.util.List;
import java.util.stream.Stream;

public class DesignPatternsMain {
    public static void main(String[] args) {

        //-MVC

        System.out.println("-----------------------");
        //-Singleton
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool(9);

        System.out.println("-----------------------");
        //-Abstract factory
        //-Factory
        AbstractFactory
                .getFactory(Factory.MYSQL)
                .getDaoImplementation("employee")
                .getEntities()
                .forEach(System.out::println);

        System.out.println("-----------------------");
        //-Abstract factory
        //-Factory
        AbstractFactory
                .getFactory(Factory.MYBATIS)
                .getDaoImplementation("employee")
                .getEntities()
                .forEach(System.out::println);

        System.out.println("-----------------------");
        //-Builder
        Zoo zoo = Zoo.builder()
                .id(1L)
                .address(new Address())
                .events(List.of())
                .employees(List.of())
                .visitors(List.of())
                .name("The zoo")
                .build();
        System.out.println(zoo);

        System.out.println("-----------------------");
        //-Observer
        MarketingDepartment marketingDepartment = new MarketingDepartment();
        marketingDepartment.addObserver((s)-> System.out.println(s + " from lambda"));
        marketingDepartment.addObserver(new Tv());
        marketingDepartment.addObserver(new WebPage());
        marketingDepartment.setNews("Hello");

        System.out.println("-----------------------");
        //-Facade
        Facade facade = new Facade();
        Zoo aSampleZoo = facade.createASampleZoo();
        System.out.println(aSampleZoo);

        System.out.println("-----------------------");
        //-Decorator
        DecoratorInterface decoratorBase = new DecoratorBase(new Notifier());
        decoratorBase.startShow();

        System.out.println("-----------------------");
        //-Strategy
        int[] array = {1,4,2,1,56,8,43,2,53,21,35,2,45};
        Sorter bubbleSort = new Sorter(new BubbleSort());
        //bubbleSort.sort(array);


        Sorter mergeSort = new Sorter(new MergeSort());
        mergeSort.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
