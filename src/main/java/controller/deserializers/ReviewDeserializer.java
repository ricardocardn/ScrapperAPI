package controller.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import model.Address;
import model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewDeserializer {
    public ReviewDeserializer() {}

    public List<Review> reviewJsonDeserializer(JsonElement json) {
        List<Review> reviews = new ArrayList<>();
        for (JsonElement review : json.getAsJsonArray()) {
            reviews.add(new Gson().fromJson(review, Review.class));
        }

        return reviews;
    }
}
