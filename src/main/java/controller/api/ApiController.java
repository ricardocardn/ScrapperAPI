package controller.api;

import com.google.gson.Gson;
import controller.Main;
import controller.api.activemq.DataReceiver;
import controller.api.activemq.RequestSender;
import model.Hotel;
import model.Request;
import model.Review;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.get;
import static spark.Spark.port;

public class ApiController extends Thread {
    private static Gson gson = new Gson();
    public static List<Hotel> hotels;

    public static void main(String[] args) {
        port(8088);

        get("/v1/:service/hotels", (req, res) -> {
            Request request = new Request();
            request.setObjectType(new Hotel());
            request.setRequestInfo("hotels");

            RequestSender.subject = req.params(":service") + "Queue";

            request.setQueryParams(req.queryParams().stream()
                            .collect(Collectors.toMap(key -> key, key -> req.queryParams(key))));

            System.out.println("ok");
            System.out.println(request.toString());
            RequestSender messageSender = new RequestSender(new Gson().toJson(request));
            DataReceiver dataReceiver = new DataReceiver();
            return dataReceiver.receive();
        });

        get("/v1/:service/hotels/:id", (req, res) -> {
            Request request = new Request();
            request.setObjectType(new Hotel());
            request.setRequestInfo("hotelId");
            request.setId(Integer.parseInt(req.params(":id")));

            request.setQueryParams(req.queryParams().stream()
                    .collect(Collectors.toMap(key -> key, key -> req.queryParams(key))));

            RequestSender.subject = req.params(":service") + "Queue";

            RequestSender messageSender = new RequestSender(new Gson().toJson(request));
            DataReceiver dataReceiver = new DataReceiver();
            return dataReceiver.receive();
        });

        get("/v1/:service/hotels/:id/reviews", (req, res) -> {
            Request request = new Request();
            request.setObjectType(new Hotel());
            request.setRequestInfo("reviews");
            request.setId(Integer.parseInt(req.params(":id")));

            request.setQueryParams(req.queryParams().stream()
                    .collect(Collectors.toMap(key -> key, key -> req.queryParams(key))));

            RequestSender.subject = req.params(":service") + "Queue";

            RequestSender messageSender = new RequestSender(new Gson().toJson(request));
            DataReceiver dataReceiver = new DataReceiver();
            return dataReceiver.receive();

           });
    }
}
