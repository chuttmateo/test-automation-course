package laba.homework.models;

import java.util.List;

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

    public List<Animal> getFavoriteAnimals() {
        return favoriteAnimals;
    }

    public void setFavoriteAnimals(List<Animal> favoriteAnimals) {
        this.favoriteAnimals = favoriteAnimals;
    }
}
