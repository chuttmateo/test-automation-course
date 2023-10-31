package laba.homework.models;

import java.util.List;
import java.util.Objects;

public class Vet extends Worker{

    private List<Animal> favoriteAnimals;

    public Vet(String firstName, String lastName, String email, Address address, String company, List<Animal> favoriteAnimals) {
        super(firstName, lastName, email, address, company);
        this.favoriteAnimals = favoriteAnimals;
    }

    @Override
    public void toWork() {
        System.out.println("I'm a vet and I'm working");
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