package com.solvd.zoomaven.models;

public abstract class Animal {
    protected Integer weight;
    protected String color;

    public Animal(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
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
}
