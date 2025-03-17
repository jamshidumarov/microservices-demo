package dzamsheed.uz.amqp_subscriber.activeMQ;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQSubscriber {

    @JmsListener(destination = "test-queue")
    public void receiveMessage(String message) {
        System.out.println("Received message activeMQ: " + message);
    }
}
