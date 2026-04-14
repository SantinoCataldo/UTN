package Guia2.model.dto.requestdto;

import lombok.Data;

@Data
public class SaleCreateRequestDTO {
    private Long userId;
    private Long productId;
    private int quantity;
}

