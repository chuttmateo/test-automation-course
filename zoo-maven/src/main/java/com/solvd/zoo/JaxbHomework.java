package com.solvd.zoo;

import com.solvd.zoo.model.*;
import com.solvd.zoo.model.parser.Jaxb.JaxbParser;

import java.time.LocalDateTime;
import java.util.List;

public class JaxbHomework {
    public static void main(String[] args) {

        Address address = new Address(1L, "Paris");
        Passport passport = new Passport(1L, "abc123");
        Employee employee = new Employee(1L, "Nina", "Audicio", passport, address);
        Ticket ticket = new Ticket(1L, "abc123", 50.0);
        Ticket ticket1 = new Ticket(2L, "abc124", 50.0);
        Event event = new Event(1L, "Crazy Monkeys", LocalDateTime.now(), List.of(ticket, ticket1));

        JaxbParser.marshall(address.getClass(), address, "address");
        JaxbParser.marshall(passport.getClass(), passport, "passport");
        JaxbParser.marshall(employee.getClass(), employee, "employee");
        JaxbParser.marshall(ticket.getClass(), ticket, "ticket");
        JaxbParser.marshall(event.getClass(), event, "event");


        Employee employee1 = (Employee) JaxbParser.unmarshal(employee.getClass(), "src/main/resources/jaxb-xml/employee.xml");
        System.out.println(employee1);
        Event event1 = (Event) JaxbParser.unmarshal(event.getClass(), "src/main/resources/jaxb-xml/event.xml");
        System.out.println(event1);


    }
}
