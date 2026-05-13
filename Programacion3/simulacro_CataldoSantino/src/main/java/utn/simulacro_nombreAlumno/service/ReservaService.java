package utn.simulacro_nombreAlumno.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utn.simulacro_nombreAlumno.exception.RecursoNoEncontradoException;
import utn.simulacro_nombreAlumno.exception.ReglaNegocioException;
import utn.simulacro_nombreAlumno.exception.StockInsuficienteException;
import utn.simulacro_nombreAlumno.mapper.ReservaMapper;
import utn.simulacro_nombreAlumno.model.EstadoReserva;
import utn.simulacro_nombreAlumno.model.Juego;
import utn.simulacro_nombreAlumno.model.Reserva;
import utn.simulacro_nombreAlumno.model.Socio;
import utn.simulacro_nombreAlumno.model.dto.request.ReservaRequestDTO;
import utn.simulacro_nombreAlumno.model.dto.response.ReservaResponseDTO;
import utn.simulacro_nombreAlumno.repository.ReservaRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final SocioService socioService;
    private final JuegoService juegoService;
    private final ReservaMapper reservaMapper;

    @Transactional
    public ReservaResponseDTO crearReserva(ReservaRequestDTO dto) {
        Socio socio = socioService.obtenerPorId(dto.getSocioId());
        if (!socio.getActivo()) throw new ReglaNegocioException("Socio inactivo");

        Juego juego = juegoService.obtenerPorId(dto.getJuegoId());
        if (!juego.getActivo()) throw new ReglaNegocioException("Juego inactivo");
        if (juego.getStockDisponible() < dto.getCantidad()) {
            throw new StockInsuficienteException("Stock insuficiente");
        }

        juego.setStockDisponible(juego.getStockDisponible() - dto.getCantidad());
        juegoService.actualizar(juego);

        Reserva reserva = new Reserva();
        reserva.setSocio(socio);
        reserva.setJuego(juego);
        reserva.setCantidad(dto.getCantidad());
        reserva.setFechaReserva(LocalDate.now());
        reserva.setFechaRetiro(dto.getFechaRetiro());
        reserva.setEstadoReserva(EstadoReserva.PENDIENTE);

        return reservaMapper.toResponse(reservaRepository.save(reserva));
    }

    @Transactional
    public ReservaResponseDTO cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Reserva no encontrada"));
        if (reserva.getEstadoReserva() == EstadoReserva.CANCELADA) {
            throw new ReglaNegocioException("La reserva ya está cancelada");
        }

        Juego juego = reserva.getJuego();
        juego.setStockDisponible(juego.getStockDisponible() + reserva.getCantidad());
        juegoService.actualizar(juego);
        reserva.setEstadoReserva(EstadoReserva.CANCELADA);

        return reservaMapper.toResponse(reservaRepository.save(reserva));
    }

    public List<ReservaResponseDTO> listarTodas() {
        return reservaRepository.findAll().stream()
                .map(reservaMapper::toResponse)
                .toList();
    }

    public List<ReservaResponseDTO> listarPorEstado(EstadoReserva estado) {
        return reservaRepository.findByEstadoReserva(estado).stream()
                .map(reservaMapper::toResponse)
                .toList();
    }

    public List<ReservaResponseDTO> listarPorSocio(Long socioId) {
        return reservaRepository.findBySocioId(socioId).stream()
                .map(reservaMapper::toResponse)
                .toList();
    }
}
