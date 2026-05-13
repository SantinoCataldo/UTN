package utn.simulacro_nombreAlumno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.simulacro_nombreAlumno.model.EstadoReserva;
import utn.simulacro_nombreAlumno.model.Reserva;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {
    List<Reserva> findByEstadoReserva(EstadoReserva estado);
    List<Reserva> findBySocioId(Long socioId);
}
