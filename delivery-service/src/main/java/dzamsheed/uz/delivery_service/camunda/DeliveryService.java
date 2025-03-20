package dzamsheed.uz.delivery_service.camunda;

import dzamsheed.uz.delivery_service.data.Delivery;
import dzamsheed.uz.delivery_service.data.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public void startDelivery(String orderId) {
        Delivery delivery = new Delivery(orderId, "IN_PROGRESS");
        deliveryRepository.save(delivery);
        System.out.println("Delivery started for Order: " + orderId);
    }

    public void cancelDelivery(String orderId) {
        Delivery delivery = deliveryRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Delivery not found: " + orderId));
        delivery.setStatus("CANCELED");
        deliveryRepository.save(delivery);
        System.out.println("Delivery canceled for Order: " + orderId);
    }
}
