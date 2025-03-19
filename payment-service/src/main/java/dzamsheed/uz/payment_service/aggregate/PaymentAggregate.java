package dzamsheed.uz.payment_service.aggregate;

import dzamsheed.uz.payment_service.command.ProcessPaymentCommand;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
@Aggregate
public class PaymentAggregate {
    @AggregateIdentifier
    private String paymentId;
    private String orderId;
    private Integer amount;
    private Double price;

    @CommandHandler
    public PaymentAggregate(ProcessPaymentCommand command) {
        log.info("ProcessPaymentCommand : {}", command.getOrderId());
    }

}

