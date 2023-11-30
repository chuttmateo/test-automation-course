package com.solvd.zoomaven.interfaces.functional;

@FunctionalInterface
public interface IConverter<F, T> {
    T convert(F from);

}

