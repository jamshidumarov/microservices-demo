package dzamsheed.uz.amqp_subscriber.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Subscriber {

    @RabbitListener(queues = "test-queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
