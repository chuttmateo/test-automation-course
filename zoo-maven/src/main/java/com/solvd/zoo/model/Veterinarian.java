package com.solvd.zoo.model;

import java.util.Objects;

public class Veterinarian {
    private Long id;
    private String specialization;
    private String firstName;
    private String lastName;

    public Veterinarian() {
    }

    public Veterinarian(Long id, String specialization, String firstName, String lastName) {
        this.id = id;
        this.specialization = specialization;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veterinarian that = (Veterinarian) o;
        return Objects.equals(id, that.id) && Objects.equals(specialization, that.specialization) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specialization, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "id=" + id +
                ", specialization='" + specialization + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
