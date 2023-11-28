package com.solvd.zoomaven.models;

import com.solvd.zoomaven.enums.Health;
import com.solvd.zoomaven.interfaces.IClimb;
import com.solvd.zoomaven.interfaces.IHide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Monkey extends Animal implements IHide, IClimb {

    private static final Logger LOGGER = LogManager.getLogger(Monkey.class);
    private int age;


    public Monkey(Integer weight, String color, Health health, int age) {
        super(weight, color, health);
        this.age = age;
    }

    @Override
    public void hideFromPredators() {
        LOGGER.info("I'm hiding from the lion and the eagle");
    }

    @Override
    public void climbTrees() {
        LOGGER.info("I'm climbing a tree");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monkey monkey = (Monkey) o;
        return age == monkey.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void eat() {
        LOGGER.info("I'm the monkey and I'm eating");
    }
}
