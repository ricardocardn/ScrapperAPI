package model;

public class Review {
    private String title;
    private int score;
    private String positive;
    private String negative;
    private String travellerType;
    private String room;
    private int nightsStay;
    private String date;
    private String country;
    private String countryCode;
    private String photos[];

    public Review(String title, int score, String positive, String negative, String travellerType, String room, int nightsStay, String date, String country, String countryCode, String[] photos) {
        this.title = title;
        this.score = score;
        this.positive = positive;
        this.negative = negative;
        this.travellerType = travellerType;
        this.room = room;
        this.nightsStay = nightsStay;
        this.date = date;
        this.country = country;
        this.countryCode = countryCode;
        this.photos = photos;
    }

    public Review() {}

    public String getTitle() {
        return title;
    }

    public int getScore() {
        return score;
    }

    public String getPositive() {
        return positive;
    }

    public String getNegative() {
        return negative;
    }

    public String getTravellerType() {
        return travellerType;
    }

    public String getRoom() {
        return room;
    }

    public int getNightsStay() {
        return nightsStay;
    }

    public String getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String[] getPhotos() {
        return photos;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public void setTravellerType(String travellerType) {
        this.travellerType = travellerType;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setNightsStay(int nightsStay) {
        this.nightsStay = nightsStay;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }
}
