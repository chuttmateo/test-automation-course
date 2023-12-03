package com.solvd.zoomaven.models;

import com.solvd.zoomaven.enums.AnimalHabitat;
import com.solvd.zoomaven.enums.Health;

import java.util.Objects;

public abstract class Animal {
    protected Integer weight;
    protected String color;
    protected Health health;
    protected AnimalHabitat habitat;
    public Animal(Integer weight, String color, Health health, AnimalHabitat habitat) {
        this.weight = weight;
        this.color = color;
        this.health = health;
        this.habitat = habitat;
    }

    public abstract void eat();

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public AnimalHabitat getHabitat() {
        return habitat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(weight, animal.weight) && Objects.equals(color, animal.color) && health == animal.health && habitat == animal.habitat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, color, health, habitat);
    }
}
