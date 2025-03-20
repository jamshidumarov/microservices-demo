package dzamsheed.uz.payment_service.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        this.orderId = orderId;
        this.status = status;
    }
}
