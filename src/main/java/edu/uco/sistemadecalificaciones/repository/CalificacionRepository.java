
package edu.uco.sistemadecalificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.uco.sistemadecalificaciones.model.Calificacion;

public interface CalificacionRepository
        extends JpaRepository<Calificacion, Long> {

    List<Calificacion> findByEstudianteCodigoAndMateriaCodigo(
            String codigoEstudiante,
            String codigoMateria);
}
