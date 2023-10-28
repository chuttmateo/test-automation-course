package models;

import Interfaces.CanFly;
import Interfaces.CanSwim;

public class Duck extends Animal implements CanFly, CanSwim {

    //Constructor OverLoading
    public Duck(Integer weight, String color) {
        super(weight, color);
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

}
