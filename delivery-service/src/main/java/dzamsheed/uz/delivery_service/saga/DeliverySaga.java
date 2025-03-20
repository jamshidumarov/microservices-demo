package dzamsheed.uz.delivery_service.saga;

import dzamsheed.uz.delivery_service.command.OrderShippedCommand;
import dzamsheed.uz.delivery_service.event.ShipmentEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Saga
@Slf4j
public class DeliverySaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "shipmentId")
    public void handle(ShipmentEvent event) {
        log.info("Shipment Event received for shipmentId: {}", event.getShipmentId());

        OrderShippedCommand command = new OrderShippedCommand(UUID.randomUUID().toString(), event.getOrderId());
        commandGateway.send(command);
    }
}

