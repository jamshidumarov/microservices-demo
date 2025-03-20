package dzamsheed.uz.payment_service.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayPaymentCommand {
    @TargetAggregateIdentifier
    private String payPaymentId;
    private String orderId;
    private Double sum;
    private Double lat;
    private Double lang;
}

