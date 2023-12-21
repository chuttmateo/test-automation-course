package com.solvd.zoo;

import com.solvd.zoo.dao.IAddressDAO;
import com.solvd.zoo.dao.IPassportDAO;
import com.solvd.zoo.dao.IVeterinarianDAO;
import com.solvd.zoo.dao.impl.AddressDAO;
import com.solvd.zoo.dao.impl.PassportDAO;
import com.solvd.zoo.dao.impl.VeterinarianDAO;
import com.solvd.zoo.model.Address;
import com.solvd.zoo.model.Employee;
import com.solvd.zoo.model.Passport;
import com.solvd.zoo.model.Veterinarian;
import com.solvd.zoo.service.IEmployeeService;
import com.solvd.zoo.service.impl.EmployeeService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Declaring DAO interfaces");
        IAddressDAO addressDAO = new AddressDAO();
        IPassportDAO passportDAO = new PassportDAO();
        IVeterinarianDAO veterinarianDAO = new VeterinarianDAO();

        Address address = new Address();
        address.setCity("Hello city2");
        Passport passport = new Passport();
        passport.setNumber("NUMBER " + Math.random());

        System.out.println("Saving address");
        addressDAO.saveEntity(address);
        System.out.println(address);
        System.out.println("");
        address.setCity("NY");
        addressDAO.updateEntity(address);
        System.out.println(addressDAO.getEntityById(address.getId()));
        System.out.println("");
        addressDAO.removeEntity(address);
        addressDAO.getEntities().forEach(System.out::println);

        System.out.println("Saving passport");
        passportDAO.saveEntity(passport);
        System.out.println(passport);
        System.out.println("");
        passport.setNumber("NsdafsadfY");
        passportDAO.updateEntity(passport);
        System.out.println(passportDAO.getEntityById(passport.getId()));
        System.out.println("");
        passportDAO.removeEntity(passport);
        passportDAO.getEntities().forEach(System.out::println);

        IEmployeeService employeeService = new EmployeeService();

        System.out.println(employeeService.getEntityById(1));
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Mateo");
        newEmployee.setLastName("Chutt");
        newEmployee.setPassport(passport);
        newEmployee.setAddress(address);

        System.out.println("saving employee");
        employeeService.saveEntity(newEmployee);
        System.out.println(newEmployee);
        //changing values before Update into database
        newEmployee.setFirstName("CARLOS");
        newEmployee.getAddress().setCity("BYE CITY");
        newEmployee.getPassport().setNumber("NEW NUMBER " + Math.random());
        employeeService.updateEntity(newEmployee);
        System.out.println(newEmployee);
        employeeService.removeEntity(newEmployee);

        employeeService.getEntities().forEach(System.out::println);

        System.out.println("saving veterinarian");
        Veterinarian v = new Veterinarian();
        v.setSpecialization("Farm Animals");
        v.setFirstName("Paula");
        v.setLastName("Smith");
        veterinarianDAO.saveEntity(v);
        System.out.println(v);

        veterinarianDAO.getEntities().forEach(System.out::println);

        v.setFirstName("NEW NAME");
        veterinarianDAO.updateEntity(v);

        System.out.println(veterinarianDAO.getEntityById(v.getId()));
    }
}
