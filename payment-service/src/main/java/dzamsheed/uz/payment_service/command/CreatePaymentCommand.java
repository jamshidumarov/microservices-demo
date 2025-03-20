package dzamsheed.uz.payment_service.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentCommand {
    @TargetAggregateIdentifier
    private String paymentId;
    private Integer productId;
    private Integer quantity;
    private Double price;
}

