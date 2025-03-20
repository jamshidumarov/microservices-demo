package dzamsheed.uz.payment_service.saga;

import dzamsheed.uz.payment_service.command.ProcessDeliveryCommand;
import dzamsheed.uz.payment_service.command.ProcessPaymentCommand;
import dzamsheed.uz.payment_service.event.PayPaymentEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Saga
@Slf4j
public class PaymentSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "payPaymentId")
    public void handle(PayPaymentEvent event) {
        log.info("Payment Pay Event received for payPaymentId: {}", event.getPayPaymentId());

        ProcessDeliveryCommand command = new ProcessDeliveryCommand(UUID.randomUUID().toString(), event.getOrderId(), event.getLat(), event.getLang());
        commandGateway.send(command);
    }
}

