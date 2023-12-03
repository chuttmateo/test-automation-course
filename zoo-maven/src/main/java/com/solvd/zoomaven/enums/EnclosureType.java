package com.solvd.zoomaven.enums;

public enum EnclosureType {
    AQUARIUM(50, AnimalHabitat.AQUATIC),
    AVIARY(100, AnimalHabitat.AERIAL),
    TERRARIUM(10, AnimalHabitat.TERRESTRIAL);

    private final int capacity;
    private final AnimalHabitat animalHabitat;

    EnclosureType(int capacity, AnimalHabitat animalHabitat) {
        this.capacity = capacity;
        this.animalHabitat = animalHabitat;
    }
    public int getCapacity() {
        return capacity;
    }
    public AnimalHabitat getAnimalHabitat() {
        return animalHabitat;
    }

}
