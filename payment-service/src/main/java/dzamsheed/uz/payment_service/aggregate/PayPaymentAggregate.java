package dzamsheed.uz.payment_service.aggregate;

import dzamsheed.uz.payment_service.command.PayPaymentCommand;
import dzamsheed.uz.payment_service.event.PayPaymentEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
@Aggregate
@SuppressWarnings("all")
public class PayPaymentAggregate {
    @AggregateIdentifier
    private String payPaymentId;
    private String orderId;
    private Double sum;
    private Double lat;
    private Double lang;

    @CommandHandler
    public PayPaymentAggregate(PayPaymentCommand command) {
        log.info("PayPaymentCommand : {}", command.getPayPaymentId());
        AggregateLifecycle.apply(new PayPaymentEvent(
                command.getPayPaymentId(),
                command.getOrderId(),
                command.getSum(),
                command.getLat(),
                command.getLang()
        ));
    }

    @EventSourcingHandler
    public void on(PayPaymentEvent event) {
        this.payPaymentId = event.getPayPaymentId();
        this.orderId = event.getOrderId();
        this.sum = event.getSum();
        this.lat = event.getLat();
        this.lang = event.getLang();
    }

}

