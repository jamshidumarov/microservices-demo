package dzamsheed.uz.saga_orchestrator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payment-service", url = "http://localhost:8087/payments")
public interface PaymentServiceClient {
    
    @PostMapping("/process/{orderId}")
    void processPayment(@PathVariable String orderId);

    @PostMapping("/rollback/{orderId}")
    void rollbackPayment(@PathVariable String orderId);
}
