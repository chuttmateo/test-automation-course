package laba.homework.models;

import laba.homework.exceptions.WrongNameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Person {

    private static final Logger LOGGER = LogManager.getLogger(Person.class);
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) throws WrongNameException {
        if (firstName.matches(".*\\d.*") || lastName.matches(".*\\d.*")) {
            LOGGER.error("The first name or last name contains numbers");
            throw new WrongNameException("The first name or last name contains numbers");
        }
        this.firstName = firstName;
        this.lastName = lastName;
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




}
