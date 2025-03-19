package dzamsheed.uz.payment_service.aggregate;

import dzamsheed.uz.payment_service.command.CreateOrderCommand;
import dzamsheed.uz.payment_service.event.OrderCreatedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
@Data
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private Integer productId;
    private Integer amount;
    private Double price;
    private String status;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {
        AggregateLifecycle.apply(new OrderCreatedEvent(
                command.getOrderId(),
                command.getProductId(),
                command.getPrice(),
                command.getAmount(),
                "PENDING"
        ));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        this.productId = event.getProductId();
        this.amount = event.getAmount();
        this.price = event.getPrice();
        this.status = event.getStatus();
    }
}


