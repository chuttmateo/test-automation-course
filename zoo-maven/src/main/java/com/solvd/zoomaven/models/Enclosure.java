package com.solvd.zoomaven.models;

import com.solvd.zoomaven.enums.EnclosureType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Enclosure {
    private static final Logger LOGGER = LogManager.getLogger(Enclosure.class);
    private final EnclosureType type;
    private final Set<Animal> animals = new HashSet<>();

    public Enclosure(EnclosureType type) {
        this.type = type;
    }

    public void addAnimal(Animal animal){
        if (animal.getHabitat() == type.getAnimalHabitat()){
            animals.add(animal);
            LOGGER.info("Animal successfully added");
        }else {
            LOGGER.warn("This animal can't access here");
        }
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public EnclosureType getType() {
        return type;
    }
}
