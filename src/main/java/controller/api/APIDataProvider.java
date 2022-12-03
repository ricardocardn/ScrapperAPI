package controller.api;
import com.google.gson.Gson;
import controller.databasecontroller.DataBaseConnection;
import controller.databasecontroller.DataBaseQuery;
import controller.databasecontroller.Query;
import model.Hotel;
import model.Review;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class APIDataProvider {
    public static void main(String[] args) {
        Query dbQueries = new DataBaseQuery(new DataBaseConnection(
                "C:\\Users\\carde\\Desktop\\ULPGC\\ScrapperAPI\\src\\main\\java\\booking.db"
        ));

        Gson gson = new Gson();

        port(8088);
        get("/v1/hotels", (req, res) -> {
            StringBuilder hotels = new StringBuilder();
            dbQueries.getObjectList("Hotels").stream()
                    .map(hotel -> (Hotel) hotel)
                    .forEach(
                            hotel -> hotels.append(gson.toJson(hotel) + ",\n")
                    );

            return '[' + hotels.toString().substring(0, hotels.toString().length() - 2) + ']';
        });

        get("/v1/hotels/:id", (req, res) -> {
            StringBuilder hotels = new StringBuilder();
            dbQueries.getObjectList("Hotels").stream()
                    .map(hotel -> (Hotel) hotel)
                    .filter(hotel -> hotel.getId() == Integer.parseInt(req.params(":id")))
                    .forEach(
                            hotel -> hotels.append(gson.toJson(hotel) + ",\n")
                    );

            return '[' + hotels.toString().substring(0, hotels.toString().length() - 2) + ']';
        });

        get("/v1/hotels/:id/reviews", (req, res) -> {
            StringBuilder reviews = new StringBuilder();
            dbQueries.getObjectList("Reviews").stream()
                    .map(review -> (Review) review)
                    .filter(review -> review.getHotelId() == Integer.parseInt(req.params(":id")))
                    .forEach(
                            review -> reviews.append(gson.toJson(review) + ",\n")
                    );

            return '[' + reviews.toString().substring(0, reviews.toString().length() - 2) + ']';
        });
    }
}
