
package edu.uco.sistemadecalificaciones.service;

import edu.uco.sistemadecalificaciones.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {

    private final List<Estudiante> estudiantes = new ArrayList<>();

    public EstudianteService() {
        estudiantes.add(new Estudiante(
            "2026001", "Daniel", "daniel@uco.edu.co"
        ));

        estudiantes.add(new Estudiante(
            "2026002", "Carlos", "carlos@uco.edu.co"
        ));
    }

    public List<Estudiante> listarEstudiantes() {
        return estudiantes;
    }

    public Estudiante registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        return estudiante;
    }
}
