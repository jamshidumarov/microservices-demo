package dzamsheed.uz.amqp_publisher.activeMQ;

import jakarta.jms.JMSException;
import org.springframework.jms.support.destination.DynamicDestinationResolver;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publisher/activemq")
public class ActiveMQPublishController {

    private final ActiveMQPublisher activeMQPublisher;

    public ActiveMQPublishController(ActiveMQPublisher activeMQPublisher) {
        this.activeMQPublisher = activeMQPublisher;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        activeMQPublisher.sendMessage(message);
        return "Message sent: " + message;
    }

    @PostMapping("/create-new-queue")
    public String createQueue(@RequestParam String queue) throws JMSException {
        new DynamicDestinationResolver()
                .resolveDestinationName(null, queue, false);
        return "Created: " + queue;
    }
}

