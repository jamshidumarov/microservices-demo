package dzamsheed.uz.payment_service.event_handler;

import dzamsheed.uz.payment_service.data.Order;
import dzamsheed.uz.payment_service.data.OrderRepository;
import dzamsheed.uz.payment_service.event.OrderCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderEventHandler {

    private final OrderRepository orderRepository;


    @EventHandler
    public void on(OrderCreatedEvent event) {
        orderRepository.save(
                Order
                        .builder()
                        .id(event.getOrderId())
                        .productId(event.getProductId())
                        .quantity(event.getQuantity())
                        .price(event.getPrice())
                        .status(event.getStatus())
                        .build()
        );
    }
}

