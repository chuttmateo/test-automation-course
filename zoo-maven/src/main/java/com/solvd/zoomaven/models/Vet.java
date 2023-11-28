package com.solvd.zoomaven.models;

import com.solvd.zoomaven.exceptions.WrongNameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class Vet extends Worker{

    private static final Logger LOGGER = LogManager.getLogger(Vet.class);
    private List<Animal> favoriteAnimals;

    public Vet(String firstName, String lastName, int phoneNumber, String email, Address address, String company, List<Animal> favoriteAnimals) throws WrongNameException {
        super(firstName, lastName, phoneNumber, email, address, company);
        this.favoriteAnimals = favoriteAnimals;
    }

    @Override
    public void toWork() {
        LOGGER.info("I'm a vet and I'm working");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vet vet = (Vet) o;
        return Objects.equals(favoriteAnimals, vet.favoriteAnimals);
    }

    @Override
    public String toString() {
        return "Vet{" +
                "favoriteAnimals=" + favoriteAnimals +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(favoriteAnimals);
    }

    public List<Animal> getFavoriteAnimals() {
        return favoriteAnimals;
    }

    public void setFavoriteAnimals(List<Animal> favoriteAnimals) {
        this.favoriteAnimals = favoriteAnimals;
    }
}
