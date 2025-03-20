package dzamsheed.uz.payment_service.model;

import lombok.Data;

@Data
public class CreateOrderModel {
    private Integer productId;
    private Integer quantity;
    private Double price;
}
