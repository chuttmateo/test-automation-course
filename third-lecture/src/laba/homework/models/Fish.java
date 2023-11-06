package laba.homework.models;

import laba.homework.interfaces.ISwim;

import java.util.Objects;

public class Fish extends Animal implements ISwim {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fish fish = (Fish) o;
        return fishScales == fish.fishScales;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fishScales);
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fishScales=" + fishScales +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    public boolean isFishScales() {
        return fishScales;
    }

    public void setFishScales(boolean fishScales) {
        this.fishScales = fishScales;
    }
}
