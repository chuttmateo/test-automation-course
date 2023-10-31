package laba.homework.models;


public class Vet extends Worker{

    private Animal[] favoriteAnimals;

    public Vet(String firstName, String lastName, String email, Address address, String company, Animal[] favoriteAnimals) {
        super(firstName, lastName, email, address, company);
        this.favoriteAnimals = favoriteAnimals;
    }

    @Override
    public void toWork() {
        System.out.println("I'm a vet and I'm working");
    }

    public Animal[] getFavoriteAnimals() {
        return favoriteAnimals;
    }

    public void setFavoriteAnimals(Animal[] favoriteAnimals) {
        this.favoriteAnimals = favoriteAnimals;
    }
}
