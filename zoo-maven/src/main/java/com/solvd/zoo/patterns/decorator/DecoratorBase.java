package com.solvd.zoo.patterns.decorator;

public class DecoratorBase implements DecoratorInterface{
    private Notifier notifier;

    public DecoratorBase(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void startShow() {
        notifier.startShow();
        System.out.println("Its price is worth it!!!");
    }
}
