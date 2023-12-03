package com.solvd.zoomaven.models;

import com.solvd.zoomaven.enums.AnimalHabitat;
import com.solvd.zoomaven.enums.Health;
import com.solvd.zoomaven.interfaces.ISwim;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Fish extends Animal implements ISwim {

    private static final Logger LOGGER = LogManager.getLogger(Fish.class);
    private boolean fishScales;


    public Fish(Integer weight, String color, Health health, boolean fishScales) {
        super(weight, color, health, AnimalHabitat.AQUATIC);
        this.fishScales = fishScales;
    }

    @Override
    public void eat() {
        LOGGER.info("Im a fish and I'm eating");
    }

    @Override
    public void swim() {
        LOGGER.info("I'm a fish and I'm swimming");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fish fish = (Fish) o;
        return super.equals(o) && fishScales == fish.fishScales;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fishScales);
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fishScales=" + fishScales +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", health=" + health +
                '}';
    }

    public boolean hasScales() {
        return fishScales;
    }

    public void setFishScales(boolean fishScales) {
        this.fishScales = fishScales;
    }
}
