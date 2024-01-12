package com.solvd.zoo.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class MarketingDepartment {
    private String news;
    private List<Observer> channels = new ArrayList<>();

    public void addObserver(Observer channel) {
        this.channels.add(channel);
    }

    public void removeObserver(Observer channel) {
        this.channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        for (Observer channel : this.channels) {
            channel.notifyObserver(this.news);
        }
    }
}
