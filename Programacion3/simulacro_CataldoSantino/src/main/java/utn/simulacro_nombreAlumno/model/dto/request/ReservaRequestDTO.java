package utn.simulacro_nombreAlumno.model.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservaRequestDTO {
    @NotNull(message = "El socioId es obligatorio")
    @Positive(message = "El socioId debe ser un número positivo")
    private Long socioId;

    @NotNull(message = "El juegoId es obligatorio")
    @Positive(message = "El juegoId debe ser un número positivo")
    private Long juegoId;

    @NotNull(message = "La cantidad es obligatoria")
    @Positive(message = "La cantidad debe ser un número positivo")
    private Integer cantidad;

    @NotNull(message = "La fechaRetiro es obligatoria")
    @FutureOrPresent
    private LocalDate fechaRetiro;

    @NotNull(message = "La fechaReserva es obligatoria")
    @FutureOrPresent
    private LocalDate fechaReserva;
}
