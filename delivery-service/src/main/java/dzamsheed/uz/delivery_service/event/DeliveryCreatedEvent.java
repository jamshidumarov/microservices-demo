package dzamsheed.uz.delivery_service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryCreatedEvent {
    private String deliveryId;
    private String orderId;
    private Double lat;
    private Double lang;
}

