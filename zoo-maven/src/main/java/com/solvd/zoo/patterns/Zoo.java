package com.solvd.zoo.patterns;

import com.solvd.zoo.model.Address;
import com.solvd.zoo.model.Employee;
import com.solvd.zoo.model.Event;
import com.solvd.zoo.model.Visitor;

import java.util.List;

public class Zoo {
    private Long id;
    private String name;
    private List<Employee> employees;
    private List<Event> events;
    private List<Visitor> visitors;
    private Address address;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public Address getAddress() {
        return address;
    }

    public static Builder builder(){
        return new Builder(new Zoo());
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                ", events=" + events +
                ", visitors=" + visitors +
                ", address=" + address +
                '}';
    }

    public static class Builder{
        private final Zoo zoo;
        public Builder(Zoo zoo){
            this.zoo = zoo;
        }

        public Builder id(Long id){
            zoo.id = id;
            return this;
        }
        public Builder name(String name){
            zoo.name = name;
            return this;
        }
        public Builder employees(List<Employee> employees){
            zoo.employees = employees;
            return this;
        }
        public Builder events(List<Event> events){
            zoo.events = events;
            return this;
        }
        public Builder visitors(List<Visitor> visitors){
            zoo.visitors = visitors;
            return this;
        }
        public Builder address(Address address){
            zoo.address = address;
            return this;
        }
        public Zoo build(){
            return zoo;
        }

    }

}

