package model;

import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private String location;
    private String type;
    private int stars;
    private float rating;
    private int totalReviews;
    private List<Review> reviews;
    private Address address;

    public Hotel(int id, String name, String location, String type, int stars, float rating, int reviews, Address address) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type = type;
        this.stars = stars;
        this.rating = rating;
        this.totalReviews = reviews;
        this.address = address;
    }

    public Hotel() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public int getStars() {
        return stars;
    }

    public float getRating() {
        return rating;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public Address getAddress() {
        return address;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", stars=" + stars +
                ", rating=" + rating +
                ", reviews=" + totalReviews +
                ", address=" + address +
                '}';
    }
}
