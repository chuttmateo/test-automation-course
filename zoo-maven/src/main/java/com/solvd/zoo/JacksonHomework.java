package com.solvd.zoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.zoo.dao.connectionpool.ConnectionPool;
import com.solvd.zoo.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class JacksonHomework {
    private static final Logger LOGGER = LogManager.getLogger(JacksonHomework.class);

    public static void main(String[] args) {
        Address address = new Address(1L, "Paris");
        Passport passport = new Passport(1L, "abc123");
        Employee employee = new Employee(1L, "Nina", "Audicio", passport, address);
        Ticket ticket = new Ticket(1L, "abc123", 50.0);
        Ticket ticket1 = new Ticket(2L, "abc124", 50.0);
        Event event = new Event(1L, "Crazy Monkeys", LocalDateTime.now(), List.of(ticket, ticket1));
        Veterinarian veterinarian = new Veterinarian(1L, "Monkeys", "Sofia", "Smith");

        serialize("src/main/resources/jackson-json/address.json", address);
        serialize("src/main/resources/jackson-json/passport.json", passport);
        serialize("src/main/resources/jackson-json/employee.json", employee);
        serialize("src/main/resources/jackson-json/event.json", event);
        serialize("src/main/resources/jackson-json/veterinarian.json", veterinarian);


        Optional<Address> addressOpt = deserialize("src/main/resources/jackson-json/address.json", Address.class);
        Optional<Passport> passportOpt = deserialize("src/main/resources/jackson-json/passport.json", Passport.class);
        Optional<Employee> employeeOpt = deserialize("src/main/resources/jackson-json/employee.json", Employee.class);
        Optional<Event> eventOpt = deserialize("src/main/resources/jackson-json/event.json", Event.class);
        Optional<Veterinarian> veterinarianOpt = deserialize("src/main/resources/jackson-json/veterinarian.json", Veterinarian.class);


        System.out.println("Address deserialized: " + addressOpt.orElse(null));
        System.out.println("Passport deserialized: " + passportOpt.orElse(null));
        System.out.println("Employee deserialized: " + employeeOpt.orElse(null));
        System.out.println("Event deserialized: " + eventOpt.orElse(null));
        System.out.println("Veterinarian deserialized: " + veterinarianOpt.orElse(null));
    }

    public static <T> void serialize(String pathName, T o) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(pathName), o);
        } catch (IOException e) {
            LOGGER.warn(e);
        }
    }
    public static <T> Optional<T> deserialize(String pathName, Class<?> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<T> data = Optional.empty();
        try {
            data = Optional.ofNullable((T) objectMapper.readValue(new File(pathName), clazz));
        } catch (IOException e) {
            LOGGER.warn(e);
        }
        return data;
    }
}
