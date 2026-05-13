package utn.simulacro_nombreAlumno.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor

public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String categoria;

    private Integer edadMinima;

    private Integer stockDisponible;

    private Boolean activo;

}
