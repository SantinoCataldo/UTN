package utn.simulacro_nombreAlumno.mapper;

import org.mapstruct.Mapper;
import utn.simulacro_nombreAlumno.model.Juego;
import utn.simulacro_nombreAlumno.model.dto.request.JuegoRequestDTO;
import utn.simulacro_nombreAlumno.model.dto.response.JuegoResponseDTO;

@Mapper(componentModel = "spring")
public interface JuegoMapper {
    Juego toEntity(JuegoRequestDTO dto);
    JuegoResponseDTO toResponse(Juego juego);
}