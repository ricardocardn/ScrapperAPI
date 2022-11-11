package model;

public class Hotel {
    private String name;
    private String location;

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Hotel() {
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
