package Guia2.model.dto.requestdto;

import lombok.Data;

@Data
public class ProductCreateRequestDTO {
    private String name;
    private double price;
    private int stock;
}

