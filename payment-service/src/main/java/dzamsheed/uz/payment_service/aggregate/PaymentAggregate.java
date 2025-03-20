package dzamsheed.uz.payment_service.aggregate;

import dzamsheed.uz.payment_service.command.ProcessPaymentCommand;
import dzamsheed.uz.payment_service.event.PaymentCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
@Aggregate
@SuppressWarnings("all")
public class PaymentAggregate {
    @AggregateIdentifier
    private String paymentId;
    private String orderId;
    private Double totalPrice;

    @CommandHandler
    public PaymentAggregate(ProcessPaymentCommand command) {
        log.info("ProcessPaymentCommand : {}", command.getOrderId());
        AggregateLifecycle.apply(new PaymentCreatedEvent(
                command.getPaymentId(),
                command.getOrderId(),
                command.getTotalPrice()
        ));
    }

    @EventSourcingHandler
    public void on(PaymentCreatedEvent event) {
        this.paymentId = event.getPaymentId();
        this.orderId = event.getOrderId();
        this.totalPrice = event.getTotalPrice();
    }

}

