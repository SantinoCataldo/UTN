package Guia2.model.dto.requestdto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateRequestDTO {
    private String name;
    private double price;
    private int stock;
}
