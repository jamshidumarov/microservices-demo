package dzamsheed.uz.delivery_service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentEvent {
    private String shipmentId;
    private String orderId;
}

