package laba.homework.models;

import laba.homework.Interfaces.IFly;
import laba.homework.Interfaces.ISwim;

import java.util.Objects;

public class Duck extends Animal implements IFly, ISwim {

    private int feathers;

    //Constructor OverLoading

    public Duck(Integer weight, String color, int feathers) {
        super(weight, color);
        this.feathers = feathers;
    }

    public Duck(String color){
        super(0, color);
    }

    @Override
    public void eat() {
        System.out.println("I'm a duck and I'm eating");
    }

    @Override
    public void fly() {
        System.out.println("I'm a duck and I can fly");
    }

    @Override
    public void swim() {
        System.out.println("I'm a duck my weight is " + getWeight() + " and I can swim");
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
