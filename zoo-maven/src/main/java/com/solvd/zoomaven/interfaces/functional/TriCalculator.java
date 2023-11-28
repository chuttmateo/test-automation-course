package com.solvd.zoomaven.interfaces.functional;

@FunctionalInterface
public interface TriCalculator<T> {
    T calculate(T a, T b, T c);

}
