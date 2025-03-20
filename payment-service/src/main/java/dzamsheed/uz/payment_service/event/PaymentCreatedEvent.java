package dzamsheed.uz.payment_service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreatedEvent {
    private String paymentId;
    private String orderId;
    private Double totalPrice;
}

