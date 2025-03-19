package dzamsheed.uz.delivery_service.module.delivery;

import dzamsheed.uz.delivery_service.module.order.Order;
import dzamsheed.uz.delivery_service.module.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    private OrderRepository orderRepository;
    @KafkaListener(topics = "payment-topic", groupId = "delivery-group")
    public void scheduleDelivery(String orderId) {
        Order order = orderRepository.findById(Long.valueOf(orderId)).orElseThrow(RuntimeException::new);
        order.setStatus("SHIPPED");
        orderRepository.save(order);
        System.out.println("Yetkazib berish boshlandi, Order ID: " + orderId);
    }
}

