
package edu.uco.sistemadecalificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uco.sistemadecalificaciones.model.UsoCelular;

public interface UsoCelularRepository
        extends JpaRepository<UsoCelular, Long> {

    long countByCalificacionId(Long calificacionId);
}

