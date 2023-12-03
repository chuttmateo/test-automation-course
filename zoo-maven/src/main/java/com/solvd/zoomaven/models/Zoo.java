package com.solvd.zoomaven.models;

import com.solvd.zoomaven.enums.AnimalHabitat;
import com.solvd.zoomaven.enums.DaysOFTheWeek;
import com.solvd.zoomaven.exceptions.FullZooException;
import com.solvd.zoomaven.exceptions.UsedTicketException;
import com.solvd.zoomaven.exceptions.WrongCompanyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Zoo {

    private static final Logger LOGGER = LogManager.getLogger(Zoo.class);
    private final List<Visitor> visitors = new ArrayList<>();
    private final List<Enclosure> enclosures = new ArrayList<>();
    private final List<Worker> workers = new ArrayList<>();
    private String name;
    private Integer capacity;
    private final Set<Integer> usedTicketId = new HashSet<>();
    private DaysOFTheWeek day;
    public Zoo(String name, DaysOFTheWeek day) {
        this.name = name;
        this.capacity = day.getCapacity();
        this.day = day;
    }

    public void checkIn(Ticket ticket, Person person) throws UsedTicketException {
        LOGGER.debug("Checking in 1/3");
        if (capacity == visitors.size()) throw new FullZooException("this zoo is at maximun capacity");
        LOGGER.debug("Checking in 2/3");
        //if (usedTicketId.contains(ticket.getId())) throw new UsedTicketException("This ticket has already been used");
        //usedTicketId.add(ticket.getId());
        //this line does the same as the previous 2 lines
        if (!usedTicketId.add(ticket.getId())) throw new UsedTicketException("This ticket has already been used");
        Visitor visitor = new Visitor(person.getFirstName(), person.getLastName(), person.getPhoneNumber(), ticket.getVisitorStatus());
        visitors.add(visitor);
        LOGGER.info("You can access to the Zoo, we hope you have a good " + day.getValue());
        LOGGER.debug("Checking in 3/3");
    }

    public void hireWorker(Worker worker) throws WrongCompanyException {
        LOGGER.debug("Hiring worker 1/2");
        if (!worker.company.equals(name)) throw new WrongCompanyException("This worker cannot work here.");
        LOGGER.debug("Hiring worker 2/2");
        workers.add(worker);
        LOGGER.info("Correctly hired worker");
    }

    public void countVisitors(){
        LOGGER.info("In this Zoo there are " + visitors.size() + " visitors.");
    }
    public void printAnimals(BiConsumer<String, Long> action){

        List<Animal> allAnimals = getAllAnimals();

        LOGGER.info("In this Zoo there are " + allAnimals.size() + " animals.");

        Map<String, Long> mapAnimalsType = allAnimals.stream().collect(
                Collectors.groupingBy( a -> a.getClass().getSimpleName(), Collectors.counting() )
        );

        mapAnimalsType.forEach(action);
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public List<Animal> getAnimals() {
        return getAllAnimals();
    }

    public void addAnimal(Animal a, Predicate<Animal> predicate){
        boolean contains = getAllAnimals().stream()
                .anyMatch(animal -> animal.equals(a));

        if (contains) {
            LOGGER.warn("This animal already is in our zoo");
            return;
        }

        Optional<Enclosure> first = getEnclosureByHabitat(a.habitat);
        if (first.isPresent() && predicate.test(a)){
            first.get().addAnimal(a);
            LOGGER.info("Animal successfully added");
        }else {
            LOGGER.info("We cannot add this animal to our zoo");
        }
    }

    public List<Worker> getWorkers() {
        return workers;
    }

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

    public void printPeopleName(Function<Person, String> l){
        for (Person person : visitors) {
            LOGGER.info(l.apply(person));
        }
        for (Person person : workers) {
            LOGGER.info(l.apply(person));
        }
    }

    public void addEnclosure(Enclosure enclosure){
        enclosures.add(enclosure);
    }

    private List<Animal> getAllAnimals(){
        return enclosures.stream()
                .flatMap((enclosure -> enclosure.getAnimals().stream()))
                .toList();
    }

    private Optional<Enclosure> getEnclosureByHabitat(AnimalHabitat animalHabitat){
        return enclosures.stream()
                .filter(enclosure -> enclosure.getType().getAnimalHabitat() == animalHabitat)
                .findFirst();
    }

}
