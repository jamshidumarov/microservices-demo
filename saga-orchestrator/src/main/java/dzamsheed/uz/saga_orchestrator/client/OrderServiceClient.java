package dzamsheed.uz.saga_orchestrator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "order-service", url = "http://localhost:8086")
public interface OrderServiceClient {
    
    @PostMapping("/orders/create/{orderId}")
    void createOrder(@PathVariable String orderId);

    @PostMapping("/orders/cancel/{orderId}")
    void cancelOrder(@PathVariable String orderId);
}
