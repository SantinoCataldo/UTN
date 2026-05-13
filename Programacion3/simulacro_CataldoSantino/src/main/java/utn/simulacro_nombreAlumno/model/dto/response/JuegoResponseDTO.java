package utn.simulacro_nombreAlumno.model.dto.response;

import lombok.Data;

@Data
public class JuegoResponseDTO {
    private Long id;
    private String nombre;
    private String categoria;
    private Integer edadMinima;
    private Integer stockDisponible;
    private Boolean activo;
}
