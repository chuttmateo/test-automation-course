package com.solvd.zoo;

import com.solvd.zoo.dao.IAddressDAO;
import com.solvd.zoo.dao.IPassportDAO;
import com.solvd.zoo.dao.implMyBatis.AddressDAOMyBatis;
import com.solvd.zoo.dao.implMyBatis.PassportDAOMyBatis;
import com.solvd.zoo.model.Address;
import com.solvd.zoo.model.Passport;


public class MyBatisMain {
    public static void main(String[] args) {
        testAddressMyBatis();
        testPassportDAOMyBatis();
    }
    public static void testPassportDAOMyBatis() {
        IPassportDAO dao = new PassportDAOMyBatis();

        // Retrieve entity by ID and print the result
        System.out.println("Entity by ID: " + dao.getEntityById(1L));

        // Create a Passport, set its number, and save it
        Passport passport = new Passport();
        passport.setNumber(String.format("NUMBER: %.5f", Math.random()));
        dao.saveEntity(passport);
        System.out.println("Passport after saving: " + passport);

        // Update the Passport object's number and update it in the database
        passport.setNumber("NEW NUMBER: 1");
        dao.updateEntity(passport);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Remove the Passport entity and print all entities
        dao.removeEntity(passport);
        System.out.println("All entities:");
        dao.getEntities().forEach(e -> System.out.println(e));
    }
    public static void testAddressMyBatis(){
        IAddressDAO dao = new AddressDAOMyBatis();

        // Retrieve entity by ID and print the result
        System.out.println("Entity by ID: " + dao.getEntityById(1L));

        // Create an Address, set its number, and save it
        Address address = new Address();
        address.setCity(String.format("CITY: %.5f", Math.random()));
        dao.saveEntity(address);
        System.out.println("Address after saving: " + address);

        // Update the Address object's number and update it in the database
        address.setCity("NEW CITY: 1");
        dao.updateEntity(address);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Remove the Address entity and print all entities
        dao.removeEntity(address);
        System.out.println("All entities:");
        dao.getEntities().forEach(System.out::println);
    }
}