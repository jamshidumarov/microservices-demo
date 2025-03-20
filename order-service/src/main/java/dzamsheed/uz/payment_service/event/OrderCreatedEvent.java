package dzamsheed.uz.payment_service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent {
    private String orderId;
    private Integer productId;
    private Double price;
    private Integer quantity;
    private String status;
}

