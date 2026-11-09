
package edu.uco.sistemadecalificaciones.controller;

import edu.uco.sistemadecalificaciones.model.Materia;
import edu.uco.sistemadecalificaciones.service.MateriaService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping("/materias")
    public List<Materia> listarMaterias() {
        return materiaService.listarMaterias();
    }

    @PostMapping("/materias")
    public Materia registrarMateria(@RequestBody Materia materia) {
        return materiaService.registrarMateria(materia);
    }
}
