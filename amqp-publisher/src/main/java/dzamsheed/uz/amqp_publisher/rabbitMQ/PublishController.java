package dzamsheed.uz.amqp_publisher.rabbitMQ;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publisher")
public class PublishController {

    private final Publisher publisher;

    public PublishController(Publisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        publisher.sendMessage(message);
        return "Message sent: " + message;
    }
}

