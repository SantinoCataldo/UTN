package Guia2.model.dto.requestdto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleCreateRequestDTO {
    private Long userId;
    private Long productId;
    private int quantity;
}
