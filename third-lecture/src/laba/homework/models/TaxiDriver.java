package laba.homework.models;

import laba.homework.exceptions.WrongNameException;

import java.util.Objects;

public class TaxiDriver extends Worker{

    private int licenceNumber;

    public TaxiDriver(String firstName, String lastName, String email, Address address, String company, int licenceNumber) throws WrongNameException {
        super(firstName, lastName, email, address, company);
        this.licenceNumber = licenceNumber;
    }

    @Override
    public void toWork() {
        System.out.println("I'm a taxi driver and I'm working");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxiDriver that = (TaxiDriver) o;
        return licenceNumber == that.licenceNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenceNumber);
    }

    @Override
    public String toString() {
        return "TaxiDriver{" +
                "licenceNumber=" + licenceNumber +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", company='" + company + '\'' +
                '}';
    }

    public int getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(int licenceNumber) {
        this.licenceNumber = licenceNumber;
    }
}
