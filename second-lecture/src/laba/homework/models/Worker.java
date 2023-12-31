package laba.homework.models;

public abstract class Worker extends Person{
    private String email;
    private Address address;

    private String company;

    public Worker(String firstName, String lastName, String email, Address address, String company) {
        super(firstName, lastName);
        this.email = email;
        this.address = address;
        this.company = company;
    }

    public abstract void toWork();

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
