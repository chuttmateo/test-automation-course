package laba.homework.models;

import laba.homework.interfaces.IAttack;
import laba.homework.interfaces.IFly;

import java.util.Objects;

public class Eagle extends Animal implements IAttack, IFly {

    private String origin;

    public Eagle(Integer weight, String color, String origin) {
        super(weight, color);
        this.origin = origin;
    }
    @Override
    public void attack() {
        System.out.println("I'm the Eagle and I'm attacking");
    }

    @Override
    public void fly() {
        System.out.println("I'm a eagle and I can fly");
    }

    @Override
    public void eat() {
        System.out.println("Eagle eating");
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
