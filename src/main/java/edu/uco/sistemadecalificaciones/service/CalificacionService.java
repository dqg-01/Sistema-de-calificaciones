
package edu.uco.sistemadecalificaciones.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.uco.sistemadecalificaciones.model.Calificacion;
import edu.uco.sistemadecalificaciones.model.Estudiante;
import edu.uco.sistemadecalificaciones.model.Materia;
import edu.uco.sistemadecalificaciones.repository.CalificacionRepository;
import edu.uco.sistemadecalificaciones.repository.EstudianteRepository;
import edu.uco.sistemadecalificaciones.repository.MateriaRepository;

@Service
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;
    private final EstudianteRepository estudianteRepository;
    private final MateriaRepository materiaRepository;

    public CalificacionService(
            CalificacionRepository calificacionRepository,
            EstudianteRepository estudianteRepository,
            MateriaRepository materiaRepository) {

        this.calificacionRepository = calificacionRepository;
        this.estudianteRepository = estudianteRepository;
        this.materiaRepository = materiaRepository;
    }

    public List<Calificacion> listarCalificaciones() {
        return calificacionRepository.findAll();
    }

    public Calificacion registrarCalificacion(
            String codigoEstudiante,
            String codigoMateria,
            double notaOriginal) {

        Estudiante estudiante = estudianteRepository.findById(codigoEstudiante)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Estudiante no encontrado"));

        Materia materia = materiaRepository.findById(codigoMateria)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Materia no encontrada"));

        if (!Double.isFinite(notaOriginal)
                || notaOriginal < 0 || notaOriginal > 5) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "La nota debe estar entre 0 y 5");
        }

        Calificacion calificacion = new Calificacion();
        calificacion.setEstudiante(estudiante);
        calificacion.setMateria(materia);
        calificacion.setNotaOriginal(notaOriginal);

        return calificacionRepository.save(calificacion);
    }
}
