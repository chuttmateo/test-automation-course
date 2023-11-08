package laba.homework.models;

import laba.homework.exceptions.WrongNameException;

public class Person {
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) throws WrongNameException {
        if (firstName.matches(".*\\d.*") || lastName.matches(".*\\d.*")) {
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
