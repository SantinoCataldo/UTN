package utn.simulacro_nombreAlumno.mapper;

import org.mapstruct.Mapper;
import utn.simulacro_nombreAlumno.model.Socio;
import utn.simulacro_nombreAlumno.model.dto.request.SocioRequestDTO;
import utn.simulacro_nombreAlumno.model.dto.response.SocioResponseDTO;

@Mapper(componentModel = "spring")
public interface SocioMapper {
    Socio toEntity(SocioRequestDTO dto);
    SocioResponseDTO toResponse(Socio socio);
}