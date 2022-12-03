package controller.api;

import com.google.gson.Gson;
import controller.Main;
import controller.api.activemq.HotelReceiver;
import model.Hotel;
import model.Review;

import static spark.Spark.get;
import static spark.Spark.port;

public class ApiController extends Thread {
    private static Gson gson = new Gson();

    public void run() {
        port(8088);
        get("/v1/hotels", (req, res) -> {
            StringBuilder hotels = new StringBuilder();
            Main.dbQueries.getObjectList("Hotels").stream()
                    .map(hotel -> (Hotel) hotel)
                    .forEach(
                            hotel -> hotels.append(gson.toJson(hotel) + ",\n")
                    );

            return '[' + hotels.toString().substring(0, hotels.toString().length() - 2) + ']';
        });

        get("/v1/hotels/:id", (req, res) -> {
            StringBuilder hFinal = new StringBuilder();
            Main.dbQueries.getObjectList("Hotels").stream()
                    .map(hotel -> (Hotel) hotel)
                    .filter(hotel -> hotel.getId() == Integer.parseInt(req.params(":id")))
                    .forEach(
                            hotel -> hFinal.append(gson.toJson(hotel))
                    );

            return hFinal.toString();
        });

        get("/v1/hotels/:id/reviews", (req, res) -> {
            StringBuilder reviews = new StringBuilder();
            Main.dbQueries.getObjectList("Reviews").stream()
                    .map(review -> (Review) review)
                    .filter(review -> review.getHotelId() == Integer.parseInt(req.params(":id")))
                    .forEach(
                            review -> reviews.append(gson.toJson(review) + ",\n")
                    );

            return '[' + reviews.toString().substring(0, reviews.toString().length() - 2) + ']';
        });
    }
}
