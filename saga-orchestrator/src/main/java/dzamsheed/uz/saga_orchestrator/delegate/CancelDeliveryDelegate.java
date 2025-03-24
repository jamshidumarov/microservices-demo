package dzamsheed.uz.saga_orchestrator.delegate;

import dzamsheed.uz.saga_orchestrator.client.DeliveryServiceClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cancelDeliveryDelegate")
public class CancelDeliveryDelegate implements JavaDelegate {
    @Autowired
    private DeliveryServiceClient deliveryServiceClient;

    @Override
    public void execute(DelegateExecution execution) {
//        String orderId = (String) execution.getVariable("orderId");
        deliveryServiceClient.cancelDelivery(execution.getBusinessKey());
    }
}