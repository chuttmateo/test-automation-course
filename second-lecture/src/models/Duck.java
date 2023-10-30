package models;

import Interfaces.CanFly;
import Interfaces.CanSwim;

public class Duck extends Animal implements CanFly, CanSwim {

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


    public int getFeathers() {
        return feathers;
    }

    public void setFeathers(int feathers) {
        this.feathers = feathers;
    }
}
