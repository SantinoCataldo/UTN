package utn.simulacro_nombreAlumno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.simulacro_nombreAlumno.model.Socio;

public interface SocioRepository extends JpaRepository<Socio,Long> {
}
