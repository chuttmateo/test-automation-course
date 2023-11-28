package com.solvd.zoomaven;

import com.solvd.zoomaven.enums.DaysOFTheWeek;
import com.solvd.zoomaven.enums.Health;
import com.solvd.zoomaven.exceptions.UsedTicketException;
import com.solvd.zoomaven.exceptions.WrongCompanyException;
import com.solvd.zoomaven.models.*;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TenthHomework {
    /*
    Create 3 custom Lambda functions with generics.
    Create 5 complex Enums(with fields, methods, blocks).*/

    public static void main(String[] args) {
        Zoo zoo = new Zoo("the zoo", DaysOFTheWeek.MONDAY);


        Person person = new Person("john", "doe", 345345);
        Person person2 = new Person("Mateo", "doe",534535);

        try {
            zoo.checkIn(new Ticket(person), person);
            zoo.checkIn(new Ticket(person2), person2);

            zoo.hireWorker(new Vet("jose", "doe", 234234, "jose@example.com", new Address("NY", 47), "the zoo", new ArrayList<>()));
        }catch (UsedTicketException | WrongCompanyException ex){
            ex.printStackTrace();
        }


        /*Use at least 5 lambda functions from the java.util.function package.*/
        Function<Person, String> personNameLambda = p -> "First Name: " + p.getFirstName() + ", Last Name: " + p.getLastName();
        zoo.printPeopleName(personNameLambda);


        Predicate<Animal> predicate = animal -> animal.getHealth() != Health.CRITICAL;
        zoo.addAnimal(new Lion(10000, "white", Health.HEALTHY, 100), predicate);
        zoo.addAnimal(new Fish(234,"white", Health.CRITICAL, true), predicate);


        BiConsumer<String, Long> printer = (k,v) -> System.out.printf("%s: %d %n", k,v);
        zoo.printAnimals(printer);


        Runnable runnable = () -> System.out.println("hello");
        Supplier<Person> supplier = () -> new Person("John", "Doe", 293487);


    }
}
