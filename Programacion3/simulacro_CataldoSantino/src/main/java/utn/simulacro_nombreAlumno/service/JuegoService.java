package utn.simulacro_nombreAlumno.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utn.simulacro_nombreAlumno.exception.RecursoNoEncontradoException;
import utn.simulacro_nombreAlumno.mapper.JuegoMapper;
import utn.simulacro_nombreAlumno.model.Juego;
import utn.simulacro_nombreAlumno.model.dto.request.JuegoRequestDTO;
import utn.simulacro_nombreAlumno.model.dto.response.JuegoResponseDTO;
import utn.simulacro_nombreAlumno.repository.JuegoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JuegoService {

    private final JuegoRepository juegoRepository;
    private final JuegoMapper juegoMapper;

    public Juego obtenerPorId(Long id) {
        return juegoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Juego no encontrado"));
    }

    public void actualizar(Juego juego) {
        juegoRepository.save(juego);
    }

    public List<JuegoResponseDTO> listar() {
        return juegoRepository.findAll().stream()
                .map(juegoMapper::toResponse)
                .toList();
    }

    public JuegoResponseDTO buscarPorId(Long id) {
        return juegoMapper.toResponse(obtenerPorId(id));
    }

    public JuegoResponseDTO crear(JuegoRequestDTO dto) {
        Juego juego = juegoMapper.toEntity(dto);
        return juegoMapper.toResponse(juegoRepository.save(juego));
    }
}
