package dzamsheed.uz.payment_service.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessPaymentCommand implements Serializable {
    @TargetAggregateIdentifier
    private String paymentId;
    private String orderId;
    private Double totalPrice;
}

