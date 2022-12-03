package controller.api.activemq;

import com.google.gson.Gson;
import controller.Main;
import controller.databasecontroller.DataBaseConnection;
import controller.databasecontroller.DataBaseQuery;
import controller.databasecontroller.Query;
import controller.deserializers.HotelDeserializer;
import model.Hotel;
import model.Review;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

import static org.apache.activemq.ActiveMQConnection.DEFAULT_BROKER_URL;
import static spark.Spark.get;
import static spark.Spark.port;

public class HotelReceiver extends Thread {

    // URL of the JMS server
    private static String url = DEFAULT_BROKER_URL;
    // default broker URL is : tcp://localhost:61616"

    // Name of the queue we will receive messages from
    private static String subject = "Hotels";

    public void run() {
        try {
            // Getting JMS connection from the server
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.setClientID("45366540");
            connection.start();

            // Creating session for seding messages
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);

            // Getting the queue 'JCG_QUEUE'
            //Destination destination = session.createQueue(subject);
            Topic destination = session.createTopic(subject);

            // MessageConsumer is used for receiving (consuming) messages
            //MessageConsumer consumer = session.createConsumer(destination);
            MessageConsumer consumer = session.createDurableSubscriber(destination, "Ricardo");

            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        Hotel hotel = new HotelDeserializer().hotelJsonDeserializer(((TextMessage)message).getText(), false);
                        Main.dataBaseDDL.insertIntoHotels(hotel);
                        System.out.println(hotel.toString());
                    } catch (JMSException e) {
                        throw new RuntimeException();
                    }
                }
            });
        } catch (JMSException e) {}
    }
}