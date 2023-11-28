package com.solvd.zoomaven.models;

import com.solvd.zoomaven.exceptions.WrongNameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private static final Logger LOGGER = LogManager.getLogger(Person.class);
    private final String firstName;
    private final String lastName;
    private final List<String> things = new ArrayList<>();
    private int phoneNumber;

    public Person(String firstName, String lastName, int phoneNumber) throws WrongNameException {
        if (firstName.matches(".*\\d.*") || lastName.matches(".*\\d.*")) {
            LOGGER.error("The first name or last name contains numbers");
            throw new WrongNameException("The first name or last name contains numbers");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public List<String> getThings() {
        return things;
    }
    public void addThing(String thing) {
        things.add(thing);
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
