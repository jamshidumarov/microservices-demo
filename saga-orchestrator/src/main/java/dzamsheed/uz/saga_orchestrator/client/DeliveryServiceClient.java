package dzamsheed.uz.saga_orchestrator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "delivery-service", url = "http://localhost:8088/delivery")
public interface DeliveryServiceClient {
    
    @PostMapping("/start/{orderId}")
    void startDelivery(@PathVariable String orderId);

    @PostMapping("/cancel/{orderId}")
    void cancelDelivery(@PathVariable String orderId);
}
