package utn.simulacro_nombreAlumno.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.simulacro_nombreAlumno.model.EstadoReserva;
import utn.simulacro_nombreAlumno.model.dto.request.ReservaRequestDTO;
import utn.simulacro_nombreAlumno.model.dto.response.ReservaResponseDTO;
import utn.simulacro_nombreAlumno.service.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crear(@Valid @RequestBody ReservaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.crearReserva(dto));
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> listar(
            @RequestParam(required = false) Long socioId,
            @RequestParam(required = false) EstadoReserva estado) {

        List<ReservaResponseDTO> reservas;

        if (estado != null) {
            reservas = reservaService.listarPorEstado(estado);
        } else if (socioId != null) {
            reservas = reservaService.listarPorSocio(socioId);
        } else {
            reservas = reservaService.listarTodas();
        }

        return ResponseEntity.ok(reservas);
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<ReservaResponseDTO> cancelar(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.cancelarReserva(id));
    }
}
