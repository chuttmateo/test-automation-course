package com.solvd.zoomaven.models;

import com.solvd.zoomaven.interfaces.IAttack;
import com.solvd.zoomaven.interfaces.IFly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Eagle extends Animal implements IAttack, IFly {

    Logger LOGGER = LogManager.getLogger(Eagle.class);
    private String origin;

    public Eagle(Integer weight, String color, String origin) {
        super(weight, color);
        this.origin = origin;
    }
    @Override
    public void attack() {
        LOGGER.info("I'm the Eagle and I'm attacking");
    }

    @Override
    public void fly() {
        LOGGER.info("I'm a eagle and I can fly");
    }

    @Override
    public void eat() {
        LOGGER.info("Eagle eating");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eagle eagle = (Eagle) o;
        return Objects.equals(origin, eagle.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin);
    }

    @Override
    public String toString() {
        return "Eagle{" +
                "origin='" + origin + '\'' +
                '}';
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
