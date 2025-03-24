package dzamsheed.uz.payment_service.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    private String id;
    private String orderId;
    private Double totalPrice;
    private Double paid;
    private String status;

    public Payment(String orderId, String status) {
        this.id = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.status = status;
    }
}
