package com.solvd.zoo.model;

import com.solvd.zoo.model.enums.EnclosureType;

import java.util.Objects;

public class Enclosure {
    private Long id;
    private EnclosureType type;
    private Integer capacity;

    public Enclosure() {
    }

    public Enclosure(Long id, EnclosureType type, Integer capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnclosureType getType() {
        return type;
    }

    public void setType(EnclosureType type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enclosure that = (Enclosure) o;
        return Objects.equals(id, that.id) && type == that.type && Objects.equals(capacity, that.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, capacity);
    }

    @Override
    public String toString() {
        return "Enclousure{" +
                "id=" + id +
                ", type=" + type +
                ", capacity=" + capacity +
                '}';
    }
}
