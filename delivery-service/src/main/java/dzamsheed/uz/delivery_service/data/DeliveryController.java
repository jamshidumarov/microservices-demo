package dzamsheed.uz.delivery_service.data;

import dzamsheed.uz.delivery_service.camunda.DeliveryService;
import dzamsheed.uz.delivery_service.command.ShipmentCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final CommandGateway commandGateway;
    private final DeliveryService deliveryService;

    @PostMapping("shipped/{orderId}")
    public CompletableFuture<String> pay(@PathVariable String orderId) {
        return commandGateway.send(new ShipmentCommand(UUID.randomUUID().toString(), orderId));
    }


    /// FOR CAMUNDA
    @PostMapping("/start/{orderId}")
    public ResponseEntity<String> startDelivery(@PathVariable String orderId) {
        deliveryService.startDelivery(orderId);
        return ResponseEntity.ok("Delivery started for Order: " + orderId);
    }

    @PostMapping("/cancel/{orderId}")
    public ResponseEntity<String> cancelDelivery(@PathVariable String orderId) {
        deliveryService.cancelDelivery(orderId);
        return ResponseEntity.ok("Delivery canceled for Order: " + orderId);
    }
}



