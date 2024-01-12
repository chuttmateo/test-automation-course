package com.solvd.zoo.patterns.observer;

public class WebPage implements Observer{
    @Override
    public void notifyObserver(Object o) {
        System.out.println(o + " from WebPage");
    }
}
