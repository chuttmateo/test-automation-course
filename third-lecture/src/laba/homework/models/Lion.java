package laba.homework.models;

import laba.homework.Interfaces.IAttack;

import java.util.Objects;

public class Lion extends Animal implements IAttack {
    private int age;

    public Lion(Integer weight, String color, int age) {
        super(weight, color);
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lion lion = (Lion) o;
        return age == lion.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "Lion{" +
                "age=" + age +
                '}';
    }

    @Override
    public void attack() {
        System.out.println("I'm attacking ");
    }

    @Override
    public void eat() {
        System.out.println("I'm a lion and I'm eating");
    }
}
