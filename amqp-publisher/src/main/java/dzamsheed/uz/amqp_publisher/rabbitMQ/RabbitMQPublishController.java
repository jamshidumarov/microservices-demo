package dzamsheed.uz.amqp_publisher.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publisher/rabbitmq")
public class RabbitMQPublishController {

    private final RabbitMQPublisher rabbitMQPublisher;
    private final RabbitAdmin rabbitAdmin;

    public RabbitMQPublishController(RabbitMQPublisher rabbitMQPublisher, RabbitAdmin rabbitAdmin) {
        this.rabbitMQPublisher = rabbitMQPublisher;
        this.rabbitAdmin = rabbitAdmin;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        rabbitMQPublisher.sendMessage(message);
        return "Message sent: " + message;
    }

    @PostMapping("/create-new-queue")
    public String createQueue(@RequestParam String queue, @RequestParam boolean durable) {
        rabbitAdmin.declareQueue(new Queue(queue, durable));
        return "Created: " + queue;
    }
}

