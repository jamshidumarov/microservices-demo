package dzamsheed.uz.amqp_subscriber.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaSubscriber {

    @KafkaListener(topics = "topic", groupId = "group")
    public void receiveMessage(String message) {
        System.out.println("Received message kafka: " + message);
    }
}
