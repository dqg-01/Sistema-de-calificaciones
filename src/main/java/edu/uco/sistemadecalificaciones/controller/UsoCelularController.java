
package edu.uco.sistemadecalificaciones.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

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
    public UsoCelular registrar(@RequestParam Long calificacionId) {
        return servicio.registrarUso(calificacionId);
    }

    @GetMapping
    public List<UsoCelular> listar() {
        return servicio.listarUsos();
    }

    @GetMapping("/nota-final/{calificacionId}")
    public double consultarNotaFinal(
            @PathVariable Long calificacionId) {
        return servicio.calcularNotaFinal(calificacionId);
    }
}

