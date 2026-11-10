
package edu.uco.sistemadecalificaciones.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Parameter;

import edu.uco.sistemadecalificaciones.model.Calificacion;
import edu.uco.sistemadecalificaciones.model.ResumenCalificacion;
import edu.uco.sistemadecalificaciones.service.CalificacionService;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    private final CalificacionService servicio;

    public CalificacionController(CalificacionService servicio) {
        this.servicio = servicio;
    }

    // Consultar todas las calificaciones
    @GetMapping
    public List<Calificacion> listar() {
        return servicio.listarCalificaciones();
    }

    // Registrar una nueva calificacion
    @PostMapping
    public Calificacion registrar(
            @Parameter(description = "Codigo del estudiante", example = "2026003")
            @RequestParam String codigoEstudiante,

            @Parameter(description = "Codigo de la materia", example = "MAT101")
            @RequestParam String codigoMateria,

            @Parameter(description = "Nota original entre 0 y 5", example = "4.5")
            @RequestParam double notaOriginal) {

        return servicio.registrarCalificacion(
            codigoEstudiante, codigoMateria, notaOriginal);
    }

    // Consultar notas originales y descuentos
    @GetMapping("/resumen")
    public List<ResumenCalificacion> consultarResumen() {
        return servicio.listarResumenes();
    }
}
