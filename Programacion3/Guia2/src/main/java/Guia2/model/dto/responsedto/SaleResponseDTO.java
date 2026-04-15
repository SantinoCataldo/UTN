package Guia2.model.dto.responsedto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleResponseDTO {
    private Long id;
    private Long userId;
    private Long productId;
    private int quantity;
    private Double totalPrice;

    public SaleResponseDTO(Long id, Long userId, Long productId, int quantity, Double totalPrice) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
