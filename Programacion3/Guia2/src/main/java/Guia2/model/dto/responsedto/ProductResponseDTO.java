package Guia2.model.dto.responsedto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long id;
    private String name;
    private double price;
    private int stock;
}

