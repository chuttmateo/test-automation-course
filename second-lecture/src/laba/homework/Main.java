package laba.homework;

import laba.homework.models.*;

public class Main {
    public static void main(String[] args) {
        /*At least 10 classes
          All classes must contain properties (minimum 1)
          At least 5 private properties (in total, in any classes)
          All private variables must have getters and setters.
          All classes should have at least one custom constructor
          Create separate class with main() which will instantiate objects of implemented classes.*/




        //polymorphism
        Animal[] animals = {
                new Duck(2500, "white", 1000),
                new Fish(500, "brown", true),
                new Duck(2000, "black", 8000),
                new Duck(3000, "white", 3000),
                new Fish(900, "brown", false)
        };

        //Contructor overloading
        Duck d1 = new Duck("white");
        Duck d2 = new Duck(3000, "white", 2000);

        //call methods from Duck class
        for ( Animal animal : animals ) {
            if (animal instanceof Duck){
                ((Duck) animal).fly();
                ((Duck) animal).swim();
            }
        }

        //polymorphism
        Worker w1 = new TaxiDriver(
                "john",
                "smith",
                "taxi@gmail.com",
                new Address("New York", 9),
                "Taxis inc",
                2344);

        Worker w2 = new Vet(
                "Sofia",
                "Chutt",
                "sofia-vet@gmail.com",
                new Address("Boston",27),
                "The zoo",
                animals);



        Person[] people = new Person[]{
                new Person("Carl", "Johnson"),
                new Person("Mark", "MacAllister"),
                w2
        };



        Zoo zoo = new Zoo(people, animals);
        zoo.printAnimals();
        zoo.countPeople();
    }
}
