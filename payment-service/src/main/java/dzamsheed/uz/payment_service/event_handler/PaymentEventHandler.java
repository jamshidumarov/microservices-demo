package dzamsheed.uz.payment_service.event_handler;

import dzamsheed.uz.payment_service.data.Payment;
import dzamsheed.uz.payment_service.data.PaymentRepository;
import dzamsheed.uz.payment_service.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentEventHandler {

    private final PaymentRepository paymentRepository;


    @EventHandler
    public void on(PaymentCreatedEvent event) {
        paymentRepository.save(
                Payment
                        .builder()
                        .id(event.getPaymentId())
                        .orderId(event.getOrderId())
                        .totalPrice(event.getTotalPrice())
                        .paid(0d)
                        .build()
        );
    }
}

