package dzamsheed.uz.delivery_service.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentCommand {
    @TargetAggregateIdentifier
    private String shipmentId;
    private String orderId;
}

