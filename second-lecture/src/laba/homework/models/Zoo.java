package laba.homework.models;


public class Zoo {
    private Person[] people;
    private Animal[] animals;

    public Zoo(Person[] people, Animal[] animals) {
        this.people = people;
        this.animals = animals;
    }

    public void countPeople(){
        System.out.println("In this Zoo there are " + people.length + " people.");
    }

    public void printAnimals(){
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public Person[] getPeople() {
        return people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }
}
