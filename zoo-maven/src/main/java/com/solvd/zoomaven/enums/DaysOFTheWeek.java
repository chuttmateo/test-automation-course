package com.solvd.zoomaven.enums;

public enum DaysOFTheWeek {
    MONDAY(50, "Monday"),
    TUESDAY(50, "Tuesday"),
    WEDNESDAY(50, "Wednesday"),
    THURSDAY(50, "Thursday"),
    FRIDAY(100, "Friday"),
    SATURDAY(150, "Saturday"),
    SUNDAY(150, "Sunday");

    private final int capacity;
    private final String value;
    DaysOFTheWeek(int capacity, String value){
        this.capacity = capacity;
        this.value = value;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getValue() {
        return value;
    }
}
