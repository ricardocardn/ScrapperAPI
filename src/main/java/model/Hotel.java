package model;

public class Hotel {
    private String name;
    private String location;
    private String type;
    private int stars;
    private float rating;
    private int reviews;
    private Address address;

    public Hotel(String name, String location, String type, int stars, float rating, int reviews, Address address) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.stars = stars;
        this.rating = rating;
        this.reviews = reviews;
        this.address = address;
    }

    public Hotel() {}

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

    public int getReviews() {
        return reviews;
    }

    public Address getAddress() {
        return address;
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

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", stars=" + stars +
                ", rating=" + rating +
                ", reviews=" + reviews +
                ", address=" + address +
                '}';
    }
}
