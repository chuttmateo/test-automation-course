package laba.homework.models;

public class TaxiDriver extends Worker{

    private int licenceNumber;

    public TaxiDriver(String firstName, String lastName, String email, Address address, String company, int licenceNumber) {
        super(firstName, lastName, email, address, company);
        this.licenceNumber = licenceNumber;
    }

    @Override
    public void toWork() {
        System.out.println("I'm a taxi driver and I'm working");
    }

    public int getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(int licenceNumber) {
        this.licenceNumber = licenceNumber;
    }
}
