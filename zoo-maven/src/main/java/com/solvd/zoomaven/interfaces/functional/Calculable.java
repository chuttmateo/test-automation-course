package com.solvd.zoomaven.interfaces.functional;

@FunctionalInterface
public interface Calculable<T> {
    T calculate(T x, T y);

}

