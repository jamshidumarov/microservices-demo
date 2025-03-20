package dzamsheed.uz.payment_service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayPaymentEvent {
    private String payPaymentId;
    private String orderId;
    private Double sum;
    private Double lat;
    private Double lang;
}

