package dzamsheed.uz.payment_service.model;

import lombok.Data;

@Data
public class CreateOrderModel {
    private Integer productId;
    private Integer amount;
    private Double price;
}
