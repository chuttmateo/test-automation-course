package com.solvd.zoo.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Objects;
@XmlRootElement(name = "ticket")
@XmlType(propOrder = {"id", "number", "price"})
public class Ticket {
    private Long id;
    private String number;
    private Double price;

    public Ticket() {
    }

    public Ticket(Long id, String number, Double price) {
        this.id = id;
        this.number = number;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }
    @XmlElement(name = "number")
    public void setNumber(String number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }
    @XmlElement(name = "price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(number, ticket.number) && Objects.equals(price, ticket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, price);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", price=" + price +
                '}';
    }
}
