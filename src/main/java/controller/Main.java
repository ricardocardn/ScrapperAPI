package controller;

import controller.downloader.BookingAccessor;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BookingAccessor bookingAccessor = new BookingAccessor();
        String jsonHotels = bookingAccessor.get("datasets/qeOzdY6kWAMgTz7g5/items",
                Map.of("token", "apify_api_r3gU36zgFGrxuz9jldycwMKlUKIXHw3mmXMA"));

        System.out.println(jsonHotels);
    }
}
