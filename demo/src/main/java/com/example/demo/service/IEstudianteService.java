package service;

import modelo.EstudianteDTO;

import java.util.Set;


public interface IEstudianteService {
    void crearEstudiante(EstudianteDTO estudianteDTO);
    EstudianteDTO leerEstudiante(Long id);
    void modificarEstudiante(EstudianteDTO estudianteDTO);
    void eliminarEstudiante(Long id);
    Set<EstudianteDTO> getTodos();
}
