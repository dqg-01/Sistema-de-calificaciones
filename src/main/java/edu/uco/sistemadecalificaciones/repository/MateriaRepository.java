
package edu.uco.sistemadecalificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.uco.sistemadecalificaciones.model.Materia;

public interface MateriaRepository
        extends JpaRepository<Materia, String> {
}
