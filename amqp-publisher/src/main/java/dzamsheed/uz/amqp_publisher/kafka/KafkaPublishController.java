package dzamsheed.uz.amqp_publisher.kafka;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publisher/kafka")
public class KafkaPublishController {

    private final KafkaPublisher kafkaPublisher;

    public KafkaPublishController(KafkaPublisher kafkaPublisher) {
        this.kafkaPublisher = kafkaPublisher;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaPublisher.sendMessage(message);
        return "Message sent: " + message;
    }
}

