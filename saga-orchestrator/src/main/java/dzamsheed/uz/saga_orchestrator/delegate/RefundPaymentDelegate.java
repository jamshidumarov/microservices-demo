package dzamsheed.uz.saga_orchestrator.delegate;

import dzamsheed.uz.saga_orchestrator.client.PaymentServiceClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("refundPaymentDelegate")
public class RefundPaymentDelegate implements JavaDelegate {
    @Autowired
    private PaymentServiceClient paymentServiceClient;

    @Override
    public void execute(DelegateExecution execution) {
//        String orderId = (String) execution.getVariable("orderId");
        paymentServiceClient.rollbackPayment(execution.getBusinessKey());
    }
}