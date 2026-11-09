
package edu.uco.sistemadecalificaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import edu.uco.sistemadecalificaciones.model.Estudiante;
import edu.uco.sistemadecalificaciones.repository.EstudianteRepository;

@Service
public class EstudianteService {

    private final EstudianteRepository repositorio;

    public EstudianteService(EstudianteRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Estudiante> listarEstudiantes() {
        return repositorio.findAll();
    }

    public Estudiante registrarEstudiante(Estudiante estudiante) {

        if (estudiante.getCodigo() == null ||
            estudiante.getCodigo().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "El codigo es obligatorio");
        }

        if (repositorio.existsById(estudiante.getCodigo())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "El estudiante ya existe");
        }

        return repositorio.save(estudiante);
    }
}
