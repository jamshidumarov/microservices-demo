package dzamsheed.uz.payment_service.camunda;

import dzamsheed.uz.payment_service.data.Order;
import dzamsheed.uz.payment_service.data.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(String orderId) {
        Order order = new Order(orderId, "CREATED");
        orderRepository.save(order);
        System.out.println("Order Created: " + orderId);
        return order;
    }

    public void cancelOrder(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
        order.setStatus("CANCELED");
        orderRepository.save(order);
        System.out.println("Order Canceled: " + orderId);
    }
}
