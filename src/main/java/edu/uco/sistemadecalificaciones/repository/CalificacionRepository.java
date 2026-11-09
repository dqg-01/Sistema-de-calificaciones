
package edu.uco.sistemadecalificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.uco.sistemadecalificaciones.model.Calificacion;

public interface CalificacionRepository
        extends JpaRepository<Calificacion, Long> {
}
