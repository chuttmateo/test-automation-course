package models;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Zoo {
    private List<Person> people;
    private List<Animal> animals;

    public Zoo(List<Person> people, List<Animal> animals) {
        this.people = people;
        this.animals = animals;
    }

    public void countPeople(){
        System.out.println("In this Zoo there are " + people.size() + " people.");
    }

    public void printAnimals(){
        System.out.println("In this Zoo there are " + animals.size() + " animals.");

        Map<String, Long> mapAnimalsType = animals.stream().collect(
                Collectors.groupingBy( a -> a.getClass().getSimpleName(), Collectors.counting() )
        );

        System.out.println(mapAnimalsType);
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
