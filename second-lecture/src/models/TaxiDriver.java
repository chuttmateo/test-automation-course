package models;

public class TaxiDriver extends Worker{

    public TaxiDriver(String firstName, String lastName, String email, Address address, String company) {
        super(firstName, lastName, email, address, company);
    }

    @Override
    public void toWork() {
        System.out.println("I'm a taxi driver and I'm working");
    }
}
