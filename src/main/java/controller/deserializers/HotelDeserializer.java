package controller.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import model.Address;
import model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelDeserializer {
    private static int id = 0;

    public HotelDeserializer() {}

    public List<Hotel> hotelJsonDeserializer(String json) {
        List<Hotel> hotels = new ArrayList<>();
        JsonArray items = new Gson().fromJson(json, JsonArray.class);

        for (JsonElement item : items) {
            Hotel hotel = new Hotel();
            hotel.setId(id++);
            hotel.setName(item.getAsJsonObject().get("name").getAsString());
            Address address = new AddressDeserializer().addressJsonDeserializer(item.getAsJsonObject().get("address"));
            hotel.setAddress(address);
            hotel.setType(item.getAsJsonObject().get("type").getAsString());
            try {
                hotel.setStars(item.getAsJsonObject().get("stars").getAsInt());
                hotel.setRating(item.getAsJsonObject().get("rating").getAsFloat());
            } catch (Exception e) {}
            hotel.setTotalReviews(item.getAsJsonObject().get("reviews").getAsInt());
            hotel.setReviews(new ReviewDeserializer().reviewJsonDeserializer(item.getAsJsonObject().get("userReviews")));
            hotels.add(hotel);
        }
        return hotels;
    }
}
