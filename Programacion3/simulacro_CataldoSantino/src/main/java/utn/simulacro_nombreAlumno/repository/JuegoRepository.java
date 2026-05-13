package utn.simulacro_nombreAlumno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.simulacro_nombreAlumno.model.Juego;

public interface JuegoRepository extends JpaRepository<Juego,Long> {
}
