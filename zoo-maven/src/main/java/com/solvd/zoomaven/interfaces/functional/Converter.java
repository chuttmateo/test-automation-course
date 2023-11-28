package com.solvd.zoomaven.interfaces.functional;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);

}

