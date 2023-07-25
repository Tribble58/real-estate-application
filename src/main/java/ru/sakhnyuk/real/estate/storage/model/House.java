package ru.sakhnyuk.real.estate.storage.model;

public class House {

    private Long id;
    private String address;
    private String city;
    private String state;
    private String country;

    public House() {};

    public House(String address, String city, String state, String country) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return "House{" +
                "id = " + this.id + '\'' +
                "address = '" + this.address + '\'' +
                "state = '" + this.state + '\'' +
                "country = '" + this.country + '\'' +
                '}';
    }
}
