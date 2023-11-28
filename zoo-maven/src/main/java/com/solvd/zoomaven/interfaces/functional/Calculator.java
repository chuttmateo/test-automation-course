package com.solvd.zoomaven.interfaces.functional;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T x, T y);

}

