package models;

public class Address {
    private String city;
    private Integer number;

    public Address(String city, Integer number) {
        this.city = city;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
