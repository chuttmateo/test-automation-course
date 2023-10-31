package laba.homework.models;

public abstract class Animal {
    private Integer weight;
    private String color;

    public Animal(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public abstract void eat();

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

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
