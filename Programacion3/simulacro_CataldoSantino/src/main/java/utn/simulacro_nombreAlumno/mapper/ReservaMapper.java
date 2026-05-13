package utn.simulacro_nombreAlumno.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import utn.simulacro_nombreAlumno.model.Reserva;
import utn.simulacro_nombreAlumno.model.dto.response.ReservaResponseDTO;

@Mapper(componentModel = "spring", uses = {SocioMapper.class, JuegoMapper.class})
public interface ReservaMapper {
    @Mapping(target = "socio", source = "socio")
    @Mapping(target = "juego", source = "juego")
    ReservaResponseDTO toResponse(Reserva reserva);
}