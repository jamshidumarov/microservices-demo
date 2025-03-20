package dzamsheed.uz.payment_service.data;

import dzamsheed.uz.payment_service.camunda.PaymentService;
import dzamsheed.uz.payment_service.command.PayPaymentCommand;
import dzamsheed.uz.payment_service.model.PayRequestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final CommandGateway commandGateway;
    private final PaymentService paymentService;


    /// FOR AXON
    @PostMapping
    public CompletableFuture<String> pay(@RequestBody PayRequestModel model) {
        return commandGateway.send(new PayPaymentCommand(UUID.randomUUID().toString(), model.getOrderId(), model.getSum(), model.getLat(), model.getLang()));
    }

    /// FOR CAMUNDA
    @PostMapping("/process/{orderId}")
    public ResponseEntity<String> processPayment(@PathVariable String orderId) {
        paymentService.processPayment(orderId);
        return ResponseEntity.ok("Payment processed for Order: " + orderId);
    }

    @PostMapping("/rollback/{orderId}")
    public ResponseEntity<String> rollbackPayment(@PathVariable String orderId) {
        paymentService.rollbackPayment(orderId);
        return ResponseEntity.ok("Payment rolled back for Order: " + orderId);
    }
}



