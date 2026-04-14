package Guia2.model.dto.responsedto;

import lombok.Data;

@Data
public class SaleResponseDTO {
    private Long id;
    private Long userId;
    private Long productId;
    private int quantity;
    private Double totalPrice;
}

