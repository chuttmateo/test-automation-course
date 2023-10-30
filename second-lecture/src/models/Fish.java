package models;

import Interfaces.CanSwim;

public class Fish extends Animal implements CanSwim {

    private boolean fishScales;

    public Fish(Integer weight, String color, boolean fishScales) {
        super(weight, color);
        this.fishScales = fishScales;
    }

    @Override
    public void eat() {
        System.out.println("Im a fish and I'm eating");
    }

    @Override
    public void swim() {
        System.out.println("I'm a fish and I'm swimming");
    }

    public boolean isFishScales() {
        return fishScales;
    }

    public void setFishScales(boolean fishScales) {
        this.fishScales = fishScales;
    }
}
