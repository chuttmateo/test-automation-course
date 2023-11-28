package com.solvd.zoomaven;

import com.solvd.zoomaven.enums.Health;
import com.solvd.zoomaven.exceptions.WrongNameException;
import com.solvd.zoomaven.models.*;

import java.util.ArrayList;
import java.util.List;

public class ThirdHomework {
    public static void main(String[] args) {
        /*Extend your previous homework with next features:
        Requirements:
        X Use polymorphism with at least one abstract class.
        X Create and override at least one abstract method.
        X Use protected modifier at least 5 times
        X Override methods from class Object (
            toString(),
            hashcode(),
            equals()) for at least 3 classes from the hierarchy.*/


        // Here is the UML
        // https://drive.google.com/file/d/1ckBdXep63E6FVlErL3jLCg0uoyFfvMHT/view?usp=sharing


        Animal duck = new Duck(2000, "white", Health.HEALTHY,10000);
        Animal fish = new Fish(3000,"brown", Health.HEALTHY,true);

        List<Animal> animals = new ArrayList<>();
        animals.add(duck);
        animals.add(fish);

        Worker vet=null;
        try {
            vet = new Vet("Mateo", "Chutt", 34523454, "mateo@mateo.com", new Address("MG", 6),"Vet sa", animals);

        }catch (WrongNameException ex){
            ex.printStackTrace();
        }

        //overridden method
        System.out.println("----------------------------");
        duck.eat();
        fish.eat();


        //overridden toString method
        System.out.println("----------------------------");
        System.out.println(duck);
        System.out.println(fish);
        System.out.println(vet);

        //overridden equals method
        System.out.println("----------------------------");
        Animal duck2 = new Duck(2000, "white", Health.HEALTHY,10000);
        System.out.println(duck.equals(duck2));

        //overridden hashCode method
        System.out.println("----------------------------");
        System.out.println(duck.hashCode());
        System.out.println(duck2.hashCode());


    }
}
