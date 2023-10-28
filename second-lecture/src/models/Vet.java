package models;

public class Vet extends Worker{

    public Vet(String firstName, String lastName, String email, Address address, String company) {
        super(firstName, lastName, email, address, company);
    }

    @Override
    public void toWork() {
        System.out.println("I'm a vet and I'm working");
    }
}
