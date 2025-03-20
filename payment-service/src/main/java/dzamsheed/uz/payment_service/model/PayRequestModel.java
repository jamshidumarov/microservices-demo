package dzamsheed.uz.payment_service.model;

import lombok.Data;

@Data
public class PayRequestModel {
    private String orderId;
    private Double sum;
    private Double lat;
    private Double lang;
}
