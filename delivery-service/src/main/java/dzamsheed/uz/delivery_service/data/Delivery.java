package dzamsheed.uz.delivery_service.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class Delivery {
    @Id
    private String id;
    private String orderId;
    private Double lat;
    private Double lang;
    private Boolean shipped;
    private String status;

    public Delivery(String orderId, String status) {
        this.id = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.status = status;
    }
}
