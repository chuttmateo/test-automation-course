package laba.homework.models;

import laba.homework.models.*;

import java.util.ArrayList;
import java.util.List;

public class Homework {
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



        Animal duck = new Duck(2000, "white", 10000);
        Animal fish = new Fish(3000,"brown", true);

        List<Animal> animals = new ArrayList<>();
        animals.add(duck);
        animals.add(fish);

        Worker vet = new Vet("Mateo", "Chutt", "mateo@mateo.com", new Address("MG", 6),"Vet sa", animals);

        //overridden method
        System.out.println("----------------------------");
        duck.eat();
        fish.eat();

        //protected modifier
        System.out.println("----------------------------");
        //I can do this because this "Homework" class is in the same package
        System.out.println(duck.color);
        System.out.println(duck.weight);
        System.out.println(vet.company);
        System.out.println(vet.email);
        System.out.println(vet.address);

        //overridden toString method
        System.out.println("----------------------------");
        System.out.println(duck);
        System.out.println(fish);
        System.out.println(vet);

        //overridden equals method
        System.out.println("----------------------------");
        Animal duck2 = new Duck(2000, "white", 10000);
        System.out.println(duck.equals(duck2));

        //overridden hashCode method
        System.out.println("----------------------------");
        System.out.println(duck.hashCode());
        System.out.println(duck2.hashCode());


    }
}
