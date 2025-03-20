package dzamsheed.uz.delivery_service.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderShippedCommand implements Serializable {
    @TargetAggregateIdentifier
    private String shipmentOrderId;
    private String orderId;
}

