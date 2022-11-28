package controller;

import controller.databasecontroller.DataBaseConnection;
import controller.databasecontroller.DataBaseDDL;
import controller.deserializers.HotelDeserializer;
import controller.downloader.BookingAccessor;
import model.Hotel;
import model.Review;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BookingAccessor bookingAccessor = new BookingAccessor();
        String jsonHotels = bookingAccessor.get("datasets/GpN5lr1wFD3Teaoa1/items",
               Map.of("token", "apify_api_r3gU36zgFGrxuz9jldycwMKlUKIXHw3mmXMA"));

        //DataBaseConnection dataBaseConnection = new DataBaseConnection("C:\\Users\\carde\\Desktop\\ULPGC\\Marketing\\src\\main\\java\\booking.db");
        //DataBaseDDL dataBaseDDL = new DataBaseDDL(dataBaseConnection);
        // collectData(jsonHotels, dataBaseDDL);
    }

    private static void collectData(String jsonHotels, DataBaseDDL dataBaseDDL) {
        dataBaseDDL.createHotelsTable();
        dataBaseDDL.createReviewsTable();

        for (Hotel hotel : new HotelDeserializer().hotelJsonDeserializer(jsonHotels)) {
            System.out.println(hotel);
            dataBaseDDL.insertIntoHotels(hotel);
            for (Review review : hotel.getReviews()) {
                System.out.println(review);
                dataBaseDDL.insertIntoReviews(review, hotel.getId());
            }
        }
    }
}
