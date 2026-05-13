package utn.simulacro_nombreAlumno.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaReserva;

    private LocalDate fechaRetiro;

    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estadoReserva;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    private Juego juego;
}
