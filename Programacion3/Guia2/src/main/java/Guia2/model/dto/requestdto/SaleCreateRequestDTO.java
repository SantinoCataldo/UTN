package Guia2.model.dto.requestdto;

import Guia2.validate.group.OnCreate;
import Guia2.validate.group.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleCreateRequestDTO {

    @NotNull(message = "El ID de usuario es obligatorio", groups = {OnCreate.class, OnUpdate.class})
    private Long userId;

    @NotNull(message = "El ID del producto es obligatorio", groups = {OnCreate.class, OnUpdate.class})
    private Long productId;

    @NotNull(message = "La cantidad es obligatoria", groups = {OnCreate.class, OnUpdate.class})
    @Min(value = 1, message = "La cantidad debe ser al menos 1", groups = {OnCreate.class, OnUpdate.class})
    private int quantity;
}
