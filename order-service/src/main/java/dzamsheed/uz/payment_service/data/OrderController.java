package dzamsheed.uz.payment_service.data;

import dzamsheed.uz.payment_service.camunda.OrderService;
import dzamsheed.uz.payment_service.command.CreateOrderCommand;
import dzamsheed.uz.payment_service.model.CreateOrderModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CommandGateway commandGateway;
    private final OrderService orderService;

    /// FOR AXON
    @PostMapping
    public CompletableFuture<String> createOrder(@RequestBody CreateOrderModel model) {
        return commandGateway.send(new CreateOrderCommand(UUID.randomUUID().toString(), model.getProductId(), model.getQuantity(), model.getPrice()));
    }

    /// FOR CAMUNDA
    @PostMapping("/create/{orderId}")
    public ResponseEntity<String> createOrder(@PathVariable String orderId) {
        orderService.createOrder(orderId);
        return ResponseEntity.ok("Order " + orderId + " created!");
    }

    @PostMapping("/cancel/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable String orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok("Order " + orderId + " canceled!");
    }
}



