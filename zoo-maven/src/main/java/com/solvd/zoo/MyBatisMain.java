package com.solvd.zoo;

import com.solvd.zoo.dao.IAddressDAO;
import com.solvd.zoo.dao.IEmployeeDAO;
import com.solvd.zoo.dao.IPassportDAO;
import com.solvd.zoo.dao.IVisitorDAO;
import com.solvd.zoo.dao.impl.PassportDAO;
import com.solvd.zoo.dao.implMyBatis.AddressDAOMyBatis;
import com.solvd.zoo.dao.implMyBatis.EmployeeDAOMyBatis;
import com.solvd.zoo.dao.implMyBatis.PassportDAOMyBatis;
import com.solvd.zoo.dao.implMyBatis.VisitorDAOMyBatis;
import com.solvd.zoo.model.Address;
import com.solvd.zoo.model.Employee;
import com.solvd.zoo.model.Passport;
import com.solvd.zoo.model.Visitor;
import com.solvd.zoo.service.IEmployeeService;
import com.solvd.zoo.service.IPassportService;
import com.solvd.zoo.service.impl.AddressService;
import com.solvd.zoo.service.impl.EmployeeService;
import com.solvd.zoo.service.impl.PassportService;


public class MyBatisMain {
    public static void main(String[] args) {
        //testAddressMyBatis();
        //testPassportDAOMyBatis();
        //testEmployeeMyBatis();
        //testVisitorMyBatis();


        testPassportService(new PassportService(new PassportDAO()));
        //System.out.println("------- Switch service classes to MyBatis -------");
        testPassportService(new PassportService(new PassportDAOMyBatis()));

        IEmployeeService employeeService = new EmployeeService(
                new EmployeeDAOMyBatis(),
                new PassportService(new PassportDAOMyBatis()),
                new AddressService(new AddressDAOMyBatis()));

        testEmployeeService(employeeService);

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
        dao.getEntities().forEach(System.out::println);
    }
    public static void testAddressMyBatis() {
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
    public static void testEmployeeMyBatis() {
        IEmployeeDAO employeeDAO = new EmployeeDAOMyBatis();
        IPassportDAO passportDAO = new PassportDAOMyBatis();
        IAddressDAO addressDAO = new AddressDAOMyBatis();

        // Retrieve entity by ID and print the result
        System.out.println("Entity by ID: " + employeeDAO.getEntityById(1L));

        // Create an Employee
        Address address = new Address();
        address.setCity(String.format("CITY: %.5f", Math.random()));
        addressDAO.saveEntity(address);
        Passport passport = new Passport();
        passport.setNumber(String.format("NUMBER: %.5f", Math.random()));
        passportDAO.saveEntity(passport);

        Employee employee = new Employee();
        employee.setLastName("lastName");
        employee.setFirstName("firstName");
        employee.setPassport(passport);
        employee.setAddress(address);
        employeeDAO.saveEntity(employee);

        System.out.println("Employee after saving: " + employee);

        // Update the Address object's number and update it in the database
        address.setCity("NEW CITY:  1");
        passport.setNumber("NEW NUMBER:  1");
        employeeDAO.updateEntity(employee);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Remove the Address entity and print all entities
        //employeeDAO.removeEntity(employee);
        System.out.println("All entities:");
        employeeDAO.getEntities().forEach(System.out::println);
    }
    public static void testVisitorMyBatis() {
        IVisitorDAO dao = new VisitorDAOMyBatis();

        // Retrieve entity by ID and print the result
        System.out.println("Entity by ID: " + dao.getEntityById(1L));

        // Create a Visitor, set its first_name and last_name, and save it
        Visitor visitor = new Visitor();
        visitor.setFirstName("Mateo");
        visitor.setLastName("Chutt");
        dao.saveEntity(visitor);
        System.out.println("Visitor after saving: " + visitor);

        // Update the Visitor object's number and update it in the database
        visitor.setFirstName("new firstName");
        visitor.setLastName("new lastName");
        dao.updateEntity(visitor);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Remove the Visitor entity and print all entities
        dao.removeEntity(visitor);
        System.out.println("All entities:");
        dao.getEntities().forEach(System.out::println);
    }
    public static void testPassportService(IPassportService service) {

        // Retrieve entity by ID and print the result
        System.out.println("Entity by ID: " + service.getEntityById(1L));

        // Create a Passport, set its number, and save it
        Passport passport = new Passport();
        passport.setNumber(String.format("NUMBER: %.5f", Math.random()));
        service.saveEntity(passport);
        System.out.println("Passport after saving: " + passport);

        // Update the Passport object's number and update it in the database
        passport.setNumber("NEW NUMBER: 1");
        service.updateEntity(passport);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Remove the Passport entity and print all entities
        service.removeEntity(passport);
        System.out.println("All entities:");
        service.getEntities().forEach(System.out::println);
    }
    public static void testEmployeeService(IEmployeeService employeeService) {
        // Creating a passport with a random number
        Passport passport = new Passport();
        passport.setNumber(String.format("NUMBER: %.5f", Math.random()));

        // Creating an address with a random city
        Address address = new Address();
        address.setCity(String.format("CITY: %.5f", Math.random()));

        // Creating an employee with the passport and address
        Employee employee = new Employee();
        employee.setLastName("lastName");
        employee.setFirstName("firstName");
        employee.setPassport(passport);
        employee.setAddress(address);

        // Saving the employee entity
        employeeService.saveEntity(employee);

        // Printing the saved employee details
        System.out.println("Employee Details after saving:");
        System.out.println(employee);

        // Modifying employee's address and passport number
        employee.getAddress().setCity("NEW CITY employee");
        employee.getPassport().setNumber("NEW NUMBER: " + Math.random());

        // Updating the employee entity with the modified details
        employeeService.updateEntity(employee);

        // Retrieving the employee entity by ID
        Employee entityById = employeeService.getEntityById(employee.getId());

        // Printing the retrieved employee details
        System.out.println("Employee Details after update:");
        System.out.println(entityById);

        // Removing the employee entity
        employeeService.removeEntity(employee);

        // Printing all employee entities
        System.out.println("All Employee Entities:");
        employeeService.getEntities().forEach(System.out::println);

    }
}