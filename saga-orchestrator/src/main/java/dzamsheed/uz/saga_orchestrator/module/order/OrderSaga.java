package dzamsheed.uz.saga_orchestrator.module.order;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class OrderSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderEvent event) {
        System.out.println("Order Saga started for OrderId: " + event.getOrderId());

        ProcessPaymentCommand command = new ProcessPaymentCommand(event.getOrderId(), event.getPrice());
        commandGateway.send(command);
    }
}
