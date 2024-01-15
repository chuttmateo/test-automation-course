package com.solvd.zoo.patterns.decorator;

public class Notifier implements DecoratorInterface{
    @Override
    public void startShow() {
        System.out.println("The show started");
    }
}
