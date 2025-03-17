package dzamsheed.uz.amqp_publisher.activeMQ;


import jakarta.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActiveMQConfig {

    @Bean
    public Queue myQueue() {
        return new ActiveMQQueue("test-queue");
    }
}