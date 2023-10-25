package service;

import modelo.EstudianteDTO;
import modelo.MateriaDTO;

import java.util.Set;

public interface IMateriaService {
    void crearMateria(MateriaDTO materiaDTO);
    MateriaDTO leerMateria(Long id);
    void modificarMateria(MateriaDTO materiaDTO);
    void eliminarMateria(Long id);
    Set<MateriaDTO> getTodos();
}
