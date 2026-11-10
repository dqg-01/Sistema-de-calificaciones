
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
            @Parameter(
                description = "Número de la calificación a la que se aplicará el descuento",
                example = "1")
            @RequestParam Long calificacionId) {

        return servicio.registrarUso(calificacionId);
    }

    @GetMapping
    public List<UsoCelular> listar() {
        return servicio.listarUsos();
    }

    @GetMapping("/nota-final/{calificacionId}")
    public double consultarNotaFinal(
            @Parameter(
                description = "Número de la calificación que deseas consultar",
                example = "1")
            @PathVariable Long calificacionId) {

        return servicio.calcularNotaFinal(calificacionId);
    }
}

