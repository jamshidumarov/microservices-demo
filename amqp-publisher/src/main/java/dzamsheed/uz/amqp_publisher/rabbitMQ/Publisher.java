package dzamsheed.uz.amqp_publisher.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Publisher {
    private static final String QUEUE_NAME = "test-queue";


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(QUEUE_NAME, message);
    }
}
