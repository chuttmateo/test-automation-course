package com.solvd.zoo.patterns.observer;

public class Tv implements Observer {
    private String news;

    @Override
    public void notifyObserver(Object news) {
        this.setNews((String) news);
        System.out.println(news + " from Tv");
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
