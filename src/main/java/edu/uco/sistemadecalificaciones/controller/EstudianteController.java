
package edu.uco.sistemadecalificaciones.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstudianteController {

    @GetMapping("/estudiantes")
    public List<String> listarEstudiantes() {

        return List.of("Daniel", "Carlos", "Mariana");

    }
}

