package laba.homework.models;

import laba.homework.exceptions.FullZooException;
import laba.homework.exceptions.UsedTicketException;
import laba.homework.exceptions.WrongCompanyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class Zoo {

    private static final Logger LOGGER = LogManager.getLogger(Zoo.class);
    private List<Person> people = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();
    private List<Worker> workers = new ArrayList<>();
    private String name;
    private Integer capacity;
    private final Set<Integer> ticketsIdUsed = new HashSet<>();

    public Zoo(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void checkIn(Ticket ticket, Person person) throws UsedTicketException {
        LOGGER.debug("Checking in 1/3");
        if (capacity == people.size()) throw new FullZooException("this zoo is at maximun capacity");
        LOGGER.debug("Checking in 2/3");
        //if (ticketsIdUsed.contains(ticket.getId())) throw new UsedTicketException("This ticket has already been used");
        //ticketsIdUsed.add(ticket.getId());
        //this line does the same as the previous 2 lines
        if (!ticketsIdUsed.add(ticket.getId())) throw new UsedTicketException("This ticket has already been used");
        people.add(person);
        LOGGER.info("You can access to the Zoo");
        LOGGER.debug("Checking in 3/3");
    }

    public void hireWorker(Worker worker) throws WrongCompanyException {
        LOGGER.debug("Hiring worker 1/2");
        if (!worker.company.equals(name)) throw new WrongCompanyException("This worker cannot work here.");
        LOGGER.debug("Hiring worker 2/2");
        workers.add(worker);
        LOGGER.info("Correctly hired worker");
    }

    public void countPeople(){
        LOGGER.info("In this Zoo there are " + people.size() + " people.");
    }

    public void printAnimals(){
        LOGGER.info("In this Zoo there are " + animals.size() + " animals.");

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

}
