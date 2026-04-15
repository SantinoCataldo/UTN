package Guia2.model.dto.requestdto;

import Guia2.validate.group.OnCreate;
import Guia2.validate.group.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacío", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @NotNull(message = "El precio es obligatorio", groups = {OnCreate.class, OnUpdate.class})
    @Min(value = 0, message = "El precio no puede ser negativo", groups = {OnCreate.class, OnUpdate.class})
    private Double price;

    @NotNull(message = "El stock es obligatorio", groups = {OnCreate.class, OnUpdate.class})
    @Min(value = 0, message = "El stock no puede ser negativo", groups = {OnCreate.class, OnUpdate.class})
    private Integer stock;
}
