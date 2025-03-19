package dzamsheed.uz.payment_service.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    private String id;
    private Integer productId;
    private Integer amount;
    private Double price;
    private String status;  // PENDING, PAID, SHIPPED, CANCELLED
}
