
package edu.uco.sistemadecalificaciones.controller;

import edu.uco.sistemadecalificaciones.model.Estudiante;
import edu.uco.sistemadecalificaciones.service.EstudianteService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/estudiantes")
    public List<Estudiante> listarEstudiantes() {
        return estudianteService.listarEstudiantes();
    }

    @PostMapping("/estudiantes")
    public Estudiante registrarEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.registrarEstudiante(estudiante);
    }
}

