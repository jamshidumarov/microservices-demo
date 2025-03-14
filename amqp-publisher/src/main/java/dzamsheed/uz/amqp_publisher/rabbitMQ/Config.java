package dzamsheed.uz.amqp_publisher.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private static final String QUEUE_NAME = "test-queue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }
}
