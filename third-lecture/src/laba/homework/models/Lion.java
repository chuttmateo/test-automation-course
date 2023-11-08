package laba.homework.models;

import laba.homework.interfaces.IAttack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Lion extends Animal implements IAttack {

    private static final Logger LOGGER = LogManager.getLogger(Lion.class);
    private int age;

    public Lion(Integer weight, String color, int age) {
        super(weight, color);
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lion lion = (Lion) o;
        return age == lion.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "Lion{" +
                "age=" + age +
                '}';
    }

    @Override
    public void attack() {
        LOGGER.info("I'm attacking");
    }

    @Override
    public void eat() {
        LOGGER.info("I'm a lion and I'm eating");
    }
}
