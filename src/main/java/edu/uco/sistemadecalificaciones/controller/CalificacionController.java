
package edu.uco.sistemadecalificaciones.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import edu.uco.sistemadecalificaciones.model.Calificacion;
import edu.uco.sistemadecalificaciones.service.CalificacionService;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    private final CalificacionService servicio;

    public CalificacionController(CalificacionService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Calificacion> listar() {
        return servicio.listarCalificaciones();
    }

    @PostMapping
    public Calificacion registrar(
            @RequestParam String codigoEstudiante,
            @RequestParam String codigoMateria,
            @RequestParam double notaOriginal) {

        return servicio.registrarCalificacion(
            codigoEstudiante, codigoMateria, notaOriginal);
    }
}
