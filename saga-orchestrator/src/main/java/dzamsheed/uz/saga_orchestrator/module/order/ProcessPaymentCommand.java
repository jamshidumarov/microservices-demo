package dzamsheed.uz.saga_orchestrator.module.order;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessPaymentCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private double amount;
}

