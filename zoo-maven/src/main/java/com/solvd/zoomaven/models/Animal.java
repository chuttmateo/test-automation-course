package com.solvd.zoomaven.models;

import com.solvd.zoomaven.enums.Health;

public abstract class Animal {
    protected Integer weight;
    protected String color;
    protected Health health;

    public Animal(Integer weight, String color, Health health) {
        this.weight = weight;
        this.color = color;
        this.health = health;
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
}
