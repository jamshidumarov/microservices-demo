package dzamsheed.uz.payment_service.data;

import dzamsheed.uz.payment_service.command.CreateOrderCommand;
import dzamsheed.uz.payment_service.model.CreateOrderModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<String> createOrder(@RequestBody CreateOrderModel model) {
        return commandGateway.send(new CreateOrderCommand(UUID.randomUUID().toString(), model.getProductId(), model.getAmount(), model.getPrice()));
    }
}



