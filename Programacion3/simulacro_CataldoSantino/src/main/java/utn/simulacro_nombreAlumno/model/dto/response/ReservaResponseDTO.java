package utn.simulacro_nombreAlumno.model.dto.response;

import lombok.Data;
import utn.simulacro_nombreAlumno.model.EstadoReserva;

import java.time.LocalDate;

@Data

public class ReservaResponseDTO {
    private Long id;
    private SocioResponseDTO socio;
    private JuegoResponseDTO juego;
    private Integer cantidad;
    private LocalDate fechaReserva;
    private LocalDate fechaRetiro;
    private EstadoReserva estadoReserva;
}
