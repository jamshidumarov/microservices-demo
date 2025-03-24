package dzamsheed.uz.saga_orchestrator.delegate;

import dzamsheed.uz.saga_orchestrator.client.OrderServiceClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("createOrderDelegate")
public class CreateOrderDelegate implements JavaDelegate {
    @Autowired
    private OrderServiceClient orderServiceClient;

    @Override
    public void execute(DelegateExecution execution) {
//        String orderId = (String) execution.getVariable("orderId");
        orderServiceClient.createOrder(execution.getBusinessKey());
    }
}