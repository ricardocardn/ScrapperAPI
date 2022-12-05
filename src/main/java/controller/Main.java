package controller;

import controller.api.ApiController;
import model.Hotel;
import model.Review;

public class Main {
    public static void main(String[] args) throws Exception {
        ApiController apiController = new ApiController();
        apiController.start();
    }
}
