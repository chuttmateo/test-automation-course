package com.solvd.zoo.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Objects;
@XmlRootElement(name = "address")
@XmlType(propOrder = {"id", "city"})
public class Address {
    private Long id;
    private String city;
    public Address() {
    }

    public Address(Long id, String city) {
        this.id = id;
        this.city = city;
    }

    public Long getId() {
        return id;
    }
    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }
    @XmlElement(name="city")
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
