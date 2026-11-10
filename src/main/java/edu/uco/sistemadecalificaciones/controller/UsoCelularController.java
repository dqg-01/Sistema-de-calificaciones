
package edu.uco.sistemadecalificaciones.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Parameter;

import edu.uco.sistemadecalificaciones.model.UsoCelular;
import edu.uco.sistemadecalificaciones.service.UsoCelularService;

@RestController
@RequestMapping("/usos-celular")
public class UsoCelularController {

    private final UsoCelularService servicio;

    public UsoCelularController(UsoCelularService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public UsoCelular registrar(
            @Parameter(description = "Código del estudiante", example = "2026003")
            @RequestParam String codigoEstudiante,

            @Parameter(description = "Código de la materia", example = "MUS101")
            @RequestParam String codigoMateria) {

        return servicio.registrarUso(codigoEstudiante, codigoMateria);
    }

    @GetMapping
    public List<UsoCelular> listar() {
        return servicio.listarUsos();
    }

    @GetMapping("/nota-final/{calificacionId}")
    public double consultarNotaFinal(
            @Parameter(description = "Número de la calificación", example = "1")
            @PathVariable Long calificacionId) {

        return servicio.calcularNotaFinal(calificacionId);
    }
}

