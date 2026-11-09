
package edu.uco.sistemadecalificaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import edu.uco.sistemadecalificaciones.model.Materia;
import edu.uco.sistemadecalificaciones.repository.MateriaRepository;

@Service
public class MateriaService {

    private final MateriaRepository repositorio;

    public MateriaService(MateriaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Materia> listarMaterias() {
        return repositorio.findAll();
    }

    public Materia registrarMateria(Materia materia) {

        if (materia.getCodigo() == null ||
            materia.getCodigo().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "El codigo es obligatorio");
        }

        if (repositorio.existsById(materia.getCodigo())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "La materia ya existe");
        }

        return repositorio.save(materia);
    }
}
