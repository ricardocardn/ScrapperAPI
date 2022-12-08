package controller.api.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

import static org.apache.activemq.ActiveMQConnection.DEFAULT_BROKER_URL;
import static spark.Spark.get;
import static spark.Spark.port;

public class DataReceiver {

    // URL of the JMS server
    private static String url = DEFAULT_BROKER_URL;
    // default broker URL is : tcp://localhost:61616"

    // Name of the queue we will receive messages from
    private static String subject = "hotelsQueue";

    public String receive() {
        try {
            // Getting JMS connection from the server
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.setClientID("id_admin_2");
            connection.start();

            // Creating session for seding messages
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);

            // Getting the queue 'JCG_QUEUE'
            //Destination destination = session.createQueue(subject);
            Queue destination = session.createQueue(subject);

            // MessageConsumer is used for receiving (consuming) messages
            //MessageConsumer consumer = session.createConsumer(destination);
            MessageConsumer consumer = session.createConsumer(destination);
            Message message = consumer.receive();
            connection.close();

            return ((TextMessage) message).getText();
        } catch (Exception e) {}

        return "None message received";
    }
}