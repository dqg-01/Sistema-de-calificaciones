package edu.uco.sistemadecalificaciones.service;

import edu.uco.sistemadecalificaciones.model.Materia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MateriaService {

    private final List<Materia> materias = new ArrayList<>();

    public MateriaService() {
        materias.add(new Materia("MAT101", "Matemáticas"));
        materias.add(new Materia("PRO201", "Programación"));
    }

    public List<Materia> listarMaterias() {
        return materias;
    }

    public Materia registrarMateria(Materia materia) {
        materias.add(materia);
        return materia;
    }
}

    
