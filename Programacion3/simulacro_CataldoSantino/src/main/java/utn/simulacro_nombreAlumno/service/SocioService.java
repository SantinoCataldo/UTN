package utn.simulacro_nombreAlumno.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utn.simulacro_nombreAlumno.exception.RecursoNoEncontradoException;
import utn.simulacro_nombreAlumno.mapper.SocioMapper;
import utn.simulacro_nombreAlumno.model.Socio;
import utn.simulacro_nombreAlumno.model.dto.request.SocioRequestDTO;
import utn.simulacro_nombreAlumno.model.dto.response.SocioResponseDTO;
import utn.simulacro_nombreAlumno.repository.SocioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocioService {

    private final SocioRepository socioRepository;
    private final SocioMapper socioMapper;

    public Socio obtenerPorId(Long id) {
        return socioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Socio no encontrado"));
    }

    public List<SocioResponseDTO> listar() {
        return socioRepository.findAll().stream()
                .map(socioMapper::toResponse)
                .toList();
    }

    public SocioResponseDTO buscarPorId(Long id) {
        return socioMapper.toResponse(obtenerPorId(id));
    }

    @Transactional
    public SocioResponseDTO crear(SocioRequestDTO dto) {
        Socio socio = socioMapper.toEntity(dto);
        return socioMapper.toResponse(socioRepository.save(socio));
    }
}
