package dzamsheed.uz.delivery_service.event_handler;

import dzamsheed.uz.delivery_service.data.Delivery;
import dzamsheed.uz.delivery_service.data.DeliveryRepository;
import dzamsheed.uz.delivery_service.event.ShipmentEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentEventHandler {

    private final DeliveryRepository deliveryRepository;


    @EventHandler
    public void on(ShipmentEvent event) {
        Delivery shipment = deliveryRepository.findByOrderId(event.getOrderId()).orElse(null);
        if (shipment != null){
            shipment.setShipped(true);
            deliveryRepository.save(shipment);
        }
    }
}

