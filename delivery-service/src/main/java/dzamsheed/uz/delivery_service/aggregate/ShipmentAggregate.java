package dzamsheed.uz.delivery_service.aggregate;

import dzamsheed.uz.delivery_service.command.ShipmentCommand;
import dzamsheed.uz.delivery_service.event.ShipmentEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
@Aggregate
@SuppressWarnings("all")
public class ShipmentAggregate {
    @AggregateIdentifier
    private String shipmentId;
    private String orderId;

    @CommandHandler
    public ShipmentAggregate(ShipmentCommand command) {
        log.info("ShipmentCommand : {}", command.getShipmentId());
        AggregateLifecycle.apply(new ShipmentEvent(
                command.getShipmentId(),
                command.getOrderId()
        ));
    }

    @EventSourcingHandler
    public void on(ShipmentEvent event) {
        this.shipmentId = event.getShipmentId();
        this.orderId = event.getOrderId();
    }

}

