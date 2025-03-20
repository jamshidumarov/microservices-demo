package dzamsheed.uz.delivery_service.event_handler;

import dzamsheed.uz.delivery_service.data.Delivery;
import dzamsheed.uz.delivery_service.data.DeliveryRepository;
import dzamsheed.uz.delivery_service.event.DeliveryCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryEventHandler {

    private final DeliveryRepository deliveryRepository;


    @EventHandler
    public void on(DeliveryCreatedEvent event) {
        deliveryRepository.save(
                Delivery
                        .builder()
                        .id(event.getDeliveryId())
                        .orderId(event.getOrderId())
                        .lat(event.getLat())
                        .lang(event.getLang())
                        .build()
        );
    }
}

