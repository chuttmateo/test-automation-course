package com.solvd.zoo.model;

import java.util.Objects;

public class Specie {
    private Long id;
    private String name;
    private String habitat;
    private Integer lifespan;

    public Specie() {
    }

    public Specie(Long id, String name, String habitat, Integer lifespan) {
        this.id = id;
        this.name = name;
        this.habitat = habitat;
        this.lifespan = lifespan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public Integer getLifespan() {
        return lifespan;
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specie specie = (Specie) o;
        return Objects.equals(id, specie.id) && Objects.equals(name, specie.name) && Objects.equals(habitat, specie.habitat) && Objects.equals(lifespan, specie.lifespan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, habitat, lifespan);
    }

    @Override
    public String toString() {
        return "Specie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", habitat='" + habitat + '\'' +
                ", lifespan=" + lifespan +
                '}';
    }
}
