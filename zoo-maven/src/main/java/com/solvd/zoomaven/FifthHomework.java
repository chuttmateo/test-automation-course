package com.solvd.zoomaven;


import com.solvd.zoomaven.exceptions.UsedTicketException;
import com.solvd.zoomaven.exceptions.WrongCompanyException;
import com.solvd.zoomaven.exceptions.WrongNameException;
import com.solvd.zoomaven.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FifthHomework {
    public static void main(String[] args) {
        Logger LOGGER = LogManager.getLogger(FifthHomework.class);

        List<Animal> animals = new ArrayList<>();
        animals.add(new Duck(2000, "white", 2000));
        animals.add(new Fish(3000,"brown", true));



        //Create 5 custom exceptions.
        // 1 Use try-catch with resources and creating a new person
        Person person = null;
        Scanner scanner = new Scanner(System.in);
        while (person == null) {
            try {
                System.out.println("Put your firstName:");
                String firstname = scanner.next();
                System.out.println("Put your lastName:");
                String lastname = scanner.next();
                person = new Person(firstname, lastname);
            } catch (WrongNameException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        // 2 Checking if the duck can fly

        ((Duck) animals.get(0)).fly();

        // 3-4.a Checking if the ticket is valid and if the zoo is at maximum capacity of people
        Ticket ticket = new Ticket(person);
        Zoo zoo = new Zoo("Zoo", 10);
        zoo.setAnimals(animals);
        try {
            zoo.checkIn(ticket, person);
        }catch (UsedTicketException e){
            LOGGER.warn(e.getMessage());
        }

        // 3-4.b This code will throw an exception because this ticket has already been used
        /*try {
            zoo.checkIn(ticket, person);
        }catch (UsedTicketException e){
            LOGGER.warn(e.getMessage());
            e.printStackTrace();
        }*/

        // 5 Adding a worker to the Zoo
        //hireWorker checks if worker.getCompany is equals to the zoo name
        try{
            zoo.hireWorker(new Vet("Sofia", "Ortega", "sofia@gmail.com", new Address("BA", 100), zoo.getName(), animals));
        }catch (WrongCompanyException | WrongNameException e){
            LOGGER.warn(e.getMessage());
        }

        //Handle exceptions in 2 ways.

        //Log messages to the console, file.
        //added: INFO - DEBUG - WARN

    }



}
