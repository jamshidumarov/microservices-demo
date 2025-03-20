package dzamsheed.uz.saga_orchestrator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "order-service", url = "http://localhost:8086/orders")
public interface OrderServiceClient {
    
    @PostMapping("/create/{orderId}")
    void createOrder(@PathVariable String orderId);

    @PostMapping("/cancel/{orderId}")
    void cancelOrder(@PathVariable String orderId);
}
