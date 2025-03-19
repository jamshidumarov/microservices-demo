package dzamsheed.uz.payment_service.saga;

import dzamsheed.uz.payment_service.event.OrderCreatedEvent;
import dzamsheed.uz.payment_service.command.ProcessPaymentCommand;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Saga
@Slf4j
public class OrderSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent event) {
        log.info("Order Created Event received for OrderId: {}", event.getOrderId());

        ProcessPaymentCommand command = new ProcessPaymentCommand(UUID.randomUUID().toString(), event.getOrderId(), event.getAmount(), event.getPrice());
        commandGateway.send(command);
    }
}

