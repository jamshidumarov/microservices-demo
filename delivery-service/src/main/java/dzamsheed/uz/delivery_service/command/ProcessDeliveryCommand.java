package dzamsheed.uz.delivery_service.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessDeliveryCommand implements Serializable {
    @TargetAggregateIdentifier
    private String deliveryId;
    private String orderId;
    private Double lat;
    private Double lang;
}

