package laba.homework.models;

import laba.homework.interfaces.IClimb;
import laba.homework.interfaces.IHide;

import java.util.Objects;

public class Monkey extends Animal implements IHide, IClimb {

    private int age;

    public Monkey(Integer weight, String color, int age) {
        super(weight, color);
        this.age = age;
    }

    @Override
    public void hideFromPredators() {
        System.out.println("I'm hiding from the lion and the eagle");
    }

    @Override
    public void climbTrees() {
        System.out.println("I'm climbing a tree");
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
        System.out.println("I'm the monkey and I'm eating");
    }
}
