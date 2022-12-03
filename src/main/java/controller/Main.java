package controller;

import controller.api.ApiController;
import controller.api.activemq.HotelReceiver;
import controller.databasecontroller.DataBaseConnection;
import controller.databasecontroller.DataBaseDDL;
import controller.databasecontroller.DataBaseQuery;
import controller.databasecontroller.Query;
import controller.deserializers.HotelDeserializer;
import controller.downloader.BookingAccessor;
import model.Hotel;
import model.Review;

import java.util.Map;

public class Main {

    public static DataBaseDDL dataBaseDDL = new DataBaseDDL(new DataBaseConnection(
            "C:\\Users\\carde\\Desktop\\ULPGC\\ScrapperAPI\\src\\main\\java\\booking.db"));
    public static Query dbQueries = new DataBaseQuery(new DataBaseConnection(
            "C:\\Users\\carde\\Desktop\\ULPGC\\ScrapperAPI\\src\\main\\java\\booking.db"));

    public static void main(String[] args) throws Exception {
        /*BookingAccessor bookingAccessor = new BookingAccessor();
        String jsonHotels = bookingAccessor.get("datasets/GpN5lr1wFD3Teaoa1/items",
               Map.of("token", "apify_api_r3gU36zgFGrxuz9jldycwMKlUKIXHw3mmXMA"));*/

        HotelReceiver hotelReceiver = new HotelReceiver();
        hotelReceiver.start();

        ApiController apiController = new ApiController();
        apiController.start();
    }

    private static void collectData(String jsonHotels, DataBaseDDL dataBaseDDL) {
        dataBaseDDL.createHotelsTable();
        dataBaseDDL.createReviewsTable();

        for (Hotel hotel : new HotelDeserializer().hotelsJsonDeserializer(jsonHotels)) {
            System.out.println(hotel);
            dataBaseDDL.insertIntoHotels(hotel);
            for (Review review : hotel.getReviews()) {
                System.out.println(review);
                dataBaseDDL.insertIntoReviews(review, hotel.getId());
            }
        }
    }
}
