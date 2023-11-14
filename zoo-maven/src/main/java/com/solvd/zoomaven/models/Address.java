package com.solvd.zoomaven.models;

import java.util.Objects;

public class Address {
    private String city;
    private Integer number;

    public Address(String city, Integer number) {
        this.city = city;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(number, address.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, number);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", number=" + number +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
