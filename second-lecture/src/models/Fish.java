package models;

import Interfaces.CanSwim;

public class Fish extends Animal implements CanSwim {
    public Fish(Integer weight, String color) {
        super(weight, color);
    }

    @Override
    public void eat() {
        System.out.println("Im a fish and I'm eating");
    }

    @Override
    public void swim() {
        System.out.println("I'm a fish and I'm swimming");
    }
}
