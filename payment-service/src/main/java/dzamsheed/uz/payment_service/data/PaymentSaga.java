//package dzamsheed.uz.payment_service.module.payment;
//
//import lombok.extern.slf4j.Slf4j;
//import org.axonframework.commandhandling.gateway.CommandGateway;
//import org.axonframework.modelling.saga.SagaEventHandler;
//import org.axonframework.modelling.saga.StartSaga;
//import org.axonframework.spring.stereotype.Saga;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.UUID;
//
//@Saga
//@Slf4j
//public class PaymentSaga {
//
//    @Autowired
//    private transient CommandGateway commandGateway;
//
//    @StartSaga
//    @SagaEventHandler(associationProperty = "paymentSagaId")
//    public void handle(ProcessPaymentCommand event) {
//        log.info("PaymentService: {}", event.getSagaId());
//
////        ProcessPaymentCommand command = new ProcessPaymentCommand(UUID.randomUUID().toString(), event.getSagaId(), event.getOrderId(), event.getPrice());
////        commandGateway.send(command);
//    }
//}
//
