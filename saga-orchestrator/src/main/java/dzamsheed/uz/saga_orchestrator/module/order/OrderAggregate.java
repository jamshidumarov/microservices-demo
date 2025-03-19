package dzamsheed.uz.saga_orchestrator.module.order;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import lombok.NoArgsConstructor;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class OrderAggregate {
    @AggregateIdentifier
    private String orderId;
    private String product;
    private double price;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {
        apply(new OrderEvent(command.getOrderId(), command.getProduct(), command.getPrice()));
    }

    @EventSourcingHandler
    public void on(OrderEvent event) {
        this.orderId = event.getOrderId();
        this.product = event.getProduct();
        this.price = event.getPrice();
    }
}
