package utn.simulacro_nombreAlumno.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.simulacro_nombreAlumno.model.dto.request.SocioRequestDTO;
import utn.simulacro_nombreAlumno.model.dto.response.SocioResponseDTO;
import utn.simulacro_nombreAlumno.service.SocioService;

import java.util.List;

@RestController
@RequestMapping("/api/socios")
@RequiredArgsConstructor
public class SocioController {

    private final SocioService socioService;

    @PostMapping
    public ResponseEntity<SocioResponseDTO> crear(@Valid @RequestBody SocioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(socioService.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<SocioResponseDTO>> listar() {
        return ResponseEntity.ok(socioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(socioService.buscarPorId(id));
    }
}
