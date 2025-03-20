package dzamsheed.uz.payment_service.camunda;

import dzamsheed.uz.payment_service.data.Payment;
import dzamsheed.uz.payment_service.data.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void processPayment(String orderId) {
        boolean paymentSuccess = new Random().nextBoolean(); // Random muvaffaqiyat yoki xatolik

        if (!paymentSuccess) {
            throw new RuntimeException("Payment Failed for Order: " + orderId);
        }

        Payment payment = new Payment(orderId, "SUCCESS");
        paymentRepository.save(payment);
        System.out.println("Payment Success for Order: " + orderId);
    }

    public void rollbackPayment(String orderId) {
        Payment payment = paymentRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Payment not found: " + orderId));
        payment.setStatus("FAILED");
        paymentRepository.save(payment);
        System.out.println("Payment Rolled Back for Order: " + orderId);
    }
}
