package utn.simulacro_nombreAlumno.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class JuegoRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La categoría es obligatoria")
    private String categoria;

    @Min(value = 0, message = "La edad mínima no puede ser negativa")
    private Integer edadMinima;

    @PositiveOrZero(message = "El stock debe ser mayor o igual a 0")
    private Integer stockDisponible;
}
