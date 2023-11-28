package com.solvd.zoomaven.enums;

public enum Health {
    HEALTHY(100),
    SICK(50),
    CRITICAL(5);

    private final int value;

    Health(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
