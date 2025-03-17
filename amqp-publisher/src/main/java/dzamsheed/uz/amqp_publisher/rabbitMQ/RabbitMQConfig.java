package dzamsheed.uz.amqp_publisher.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static final String TEST_QUEUE = "test-queue";
    private static final String SECOND_QUEUE = "second-queue";
    private static final String THIRD_QUEUE = "third-queue";


    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    @Bean
    public Queue testQueue() {
        return new Queue(TEST_QUEUE, true);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(SECOND_QUEUE, true);
    }

    @Bean
    public Queue thirdQueue() {
        return new Queue(THIRD_QUEUE, true);
    }
}
