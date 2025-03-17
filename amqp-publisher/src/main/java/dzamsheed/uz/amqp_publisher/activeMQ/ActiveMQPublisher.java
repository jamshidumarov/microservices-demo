package dzamsheed.uz.amqp_publisher.activeMQ;

import jakarta.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQPublisher {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue myQueue;

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(myQueue, message);
        System.out.println("Message sent activeMQ: " + message);
    }
}