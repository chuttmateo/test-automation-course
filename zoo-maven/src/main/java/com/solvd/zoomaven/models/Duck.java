package com.solvd.zoomaven.models;

import com.solvd.zoomaven.exceptions.CannotFlyException;
import com.solvd.zoomaven.interfaces.IFly;
import com.solvd.zoomaven.interfaces.ISwim;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Duck extends Animal implements IFly, ISwim {

    private static final Logger LOGGER = LogManager.getLogger(Duck.class);

    private int feathers;

    public Duck(Integer weight, String color, int feathers) {
        super(weight, color);
        this.feathers = feathers;
        LOGGER.info("Creating a duck");
    }

    @Override
    public void eat() {
        LOGGER.info("I'm a duck and I'm eating");
    }

    @Override
    public void fly() throws CannotFlyException {
        if (feathers < 2000) throw new CannotFlyException("This duck cannot fly because it has few feathers, the minimum is 2000");
        LOGGER.info("I'm a duck and I can fly");
    }

    @Override
    public void swim() {
        LOGGER.info("I'm a duck my weight is " + getWeight() + " and I can swim");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duck duck = (Duck) o;
        return feathers == duck.feathers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feathers);
    }

    @Override
    public String toString() {
        return "Duck{" +
                "feathers=" + feathers +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    public int getFeathers() {
        return feathers;
    }

    public void setFeathers(int feathers) {
        this.feathers = feathers;
    }
}
