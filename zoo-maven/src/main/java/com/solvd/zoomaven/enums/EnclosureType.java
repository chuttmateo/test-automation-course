package com.solvd.zoomaven.enums;

public enum EnclosureType {
    OPEN_AIR(10),
    AQUARIUM(50),
    AVIARY(100),
    TERRARIUM(10),
    INDOOR(5),
    PETTING_ZOO(10);

    private final int capacity;

    EnclosureType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

}
