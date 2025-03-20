package dzamsheed.uz.payment_service.event_handler;

import dzamsheed.uz.payment_service.data.Payment;
import dzamsheed.uz.payment_service.data.PaymentRepository;
import dzamsheed.uz.payment_service.event.PayPaymentEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayPaymentEventHandler {

    private final PaymentRepository paymentRepository;


    @EventHandler
    public void on(PayPaymentEvent event) {
        Payment payment = paymentRepository.findByOrderId(event.getOrderId()).orElse(null);
        if (payment != null){
            payment.setPaid(event.getSum());
            paymentRepository.save(payment);
        }
    }
}

