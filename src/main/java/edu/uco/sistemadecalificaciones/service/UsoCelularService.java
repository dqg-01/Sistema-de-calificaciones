
package edu.uco.sistemadecalificaciones.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.uco.sistemadecalificaciones.model.Calificacion;
import edu.uco.sistemadecalificaciones.model.UsoCelular;
import edu.uco.sistemadecalificaciones.repository.CalificacionRepository;
import edu.uco.sistemadecalificaciones.repository.UsoCelularRepository;

@Service
public class UsoCelularService {

    private final UsoCelularRepository usoCelularRepository;
    private final CalificacionRepository calificacionRepository;

    public UsoCelularService(
            UsoCelularRepository usoCelularRepository,
            CalificacionRepository calificacionRepository) {

        this.usoCelularRepository = usoCelularRepository;
        this.calificacionRepository = calificacionRepository;
    }

    public UsoCelular registrarUso(
            String codigoEstudiante,
            String codigoMateria) {

        List<Calificacion> calificaciones = calificacionRepository
            .findByEstudianteCodigoAndMateriaCodigo(
                codigoEstudiante, codigoMateria);

        if (calificaciones.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No existe una calificacion para ese estudiante y materia");
        }

        if (calificaciones.size() > 1) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Hay varias calificaciones para este estudiante y materia");
        }

        UsoCelular uso = new UsoCelular();
        uso.setCalificacion(calificaciones.get(0));
        uso.setFechaHora(LocalDateTime.now());

        return usoCelularRepository.save(uso);
    }

    public List<UsoCelular> listarUsos() {
        return usoCelularRepository.findAll();
    }

    public double calcularNotaFinal(Long calificacionId) {

        Calificacion calificacion = calificacionRepository
            .findById(calificacionId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Calificacion no encontrada"));

        long incidentes = usoCelularRepository
            .countByCalificacionId(calificacionId);

        double notaFinal = calificacion.getNotaOriginal()
                - (incidentes * 0.1);

        return Math.max(0, Math.round(notaFinal * 10) / 10.0);
    }
}

