package utn.simulacro_nombreAlumno.model.dto.response;

import lombok.Data;

@Data
public class SocioResponseDTO {
    private Long id;
    private String nombre;
    private String email;
    private String dni;
    private Boolean activo;
}
