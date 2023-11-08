package laba.homework.models;

import laba.homework.exceptions.FullZooException;
import laba.homework.exceptions.UsedTicketException;
import laba.homework.exceptions.WrongCompanyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Zoo {
    private List<Person> people = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();
    private List<Worker> workers = new ArrayList<>();
    private String name;
    private Integer capacity;
    private final List<Integer> ticketsIdUsed = new ArrayList<>();

    public Zoo(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void checkIn(Ticket ticket, Person person) throws UsedTicketException {
        if (capacity == people.size()) throw new FullZooException("this zoo is at maximun capacity");
        if (ticketsIdUsed.contains(ticket.getId())) throw new UsedTicketException("This ticket has already been used");
        ticketsIdUsed.add(ticket.getId());
        people.add(person);
        System.out.println("You can access to the Zoo");
    }

    public void hireWorker(Worker worker) throws WrongCompanyException {
        if (!worker.company.equals(name)) throw new WrongCompanyException("This worker cannot work here.");
        workers.add(worker);
        System.out.println("Correctly hired worker");
    }

    public void countPeople(){
        System.out.println("In this Zoo there are " + people.size() + " people.");
    }

    public void printAnimals(){
        System.out.println("In this Zoo there are " + animals.size() + " animals.");

        Map<String, Long> mapAnimalsType = animals.stream().collect(
                Collectors.groupingBy( a -> a.getClass().getSimpleName(), Collectors.counting() )
        );

        mapAnimalsType.forEach((k,v) -> System.out.printf("%s: %d %n", k,v));
        //System.out.println(mapAnimalsType);
    }

    public List<Person> getPeople() {
        return people;
    }

    /*public void setPeople(List<Person> people) {
        this.people = people;
    }*/

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    /*public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
