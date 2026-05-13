package utn.simulacro_nombreAlumno.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.simulacro_nombreAlumno.model.dto.request.JuegoRequestDTO;
import utn.simulacro_nombreAlumno.model.dto.response.JuegoResponseDTO;
import utn.simulacro_nombreAlumno.service.JuegoService;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
@RequiredArgsConstructor
public class JuegoController {

    private final JuegoService juegoService;

    @PostMapping
    public ResponseEntity<JuegoResponseDTO> crear(@Valid @RequestBody JuegoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(juegoService.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<JuegoResponseDTO>> listar() {
        return ResponseEntity.ok(juegoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JuegoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(juegoService.buscarPorId(id));
    }
}
