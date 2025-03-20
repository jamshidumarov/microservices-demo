package dzamsheed.uz.delivery_service.aggregate;

import dzamsheed.uz.delivery_service.command.ProcessDeliveryCommand;
import dzamsheed.uz.delivery_service.event.DeliveryCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
@Aggregate
@SuppressWarnings("all")
public class CreateDeliveryAggregate {
    @AggregateIdentifier
    private String deliveryId;
    private String orderId;
    private Double lat;
    private Double lang;

    @CommandHandler
    public CreateDeliveryAggregate(ProcessDeliveryCommand command) {
        log.info("ProcessDeliveryCommand : {}", command.getDeliveryId());
        AggregateLifecycle.apply(new DeliveryCreatedEvent(
                command.getDeliveryId(),
                command.getOrderId(),
                command.getLat(),
                command.getLang()
        ));
    }

    @EventSourcingHandler
    public void on(DeliveryCreatedEvent event) {
        this.deliveryId = event.getDeliveryId();
        this.orderId = event.getOrderId();
        this.lat = event.getLat();
        this.lang = event.getLang();
    }

}

