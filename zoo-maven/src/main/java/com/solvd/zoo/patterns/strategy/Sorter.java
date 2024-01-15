package com.solvd.zoo.patterns.strategy;

public class Sorter {
    private IStrategy strategy;

    public Sorter(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] arr){
        strategy.sort(arr);
    }

}
