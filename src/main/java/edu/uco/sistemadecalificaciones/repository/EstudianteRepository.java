
package edu.uco.sistemadecalificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uco.sistemadecalificaciones.model.Estudiante;

public interface EstudianteRepository
        extends JpaRepository<Estudiante, String> {
}
