package dzamsheed.uz.commonlibrary;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessPaymentCommand {

    @TargetAggregateIdentifier
    private String paymentSagaId;
    private String sagaId;
    private Integer orderId;
    private Double price;
}

