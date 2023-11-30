package com.solvd.zoomaven.interfaces.functional;

@FunctionalInterface
public interface TriCalculable<T> {
    T calculate(T a, T b, T c);

}
