package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import modelo.Estudiante;
import modelo.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IEstudianteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired //para que el framework lo instancie
    private IEstudianteRepository estudianteRepository; //Para acceder a la capa de datos

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearEstudiante(EstudianteDTO estudianteDTO) {
        guardarEstudiante(estudianteDTO);
    }

    @Override
    public EstudianteDTO leerEstudiante(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        //Optional nos permite preguntar si tiene o no un contenido
        EstudianteDTO estudianteDTO = null;
        if(estudiante.isPresent()){ //preguntamos si no es nulo
            estudianteDTO = mapper.convertValue(estudiante, EstudianteDTO.class);
        }

        return estudianteDTO;
    }

    private void guardarEstudiante(EstudianteDTO estudianteDTO){
        Estudiante estudiante = mapper.convertValue(estudianteDTO,Estudiante.class); //que nos convierta un estudianteDTO a un estudiante
        estudianteRepository.save(estudiante);
    }

    @Override
    public void modificarEstudiante(EstudianteDTO estudianteDTO) {
        // EL SAVE SIRVE PARA CREAR Y MODIFICAR
        guardarEstudiante(estudianteDTO);

    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Set<EstudianteDTO> getTodos() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        //Pero debemos devolver estudiantes DTO, entonces por cada estudiante llenamos un set de estuDTO
        Set<EstudianteDTO> estudianteDTO = new HashSet<>();
        for(Estudiante estudiante:estudiantes){
            estudianteDTO.add(mapper.convertValue(estudiante,EstudianteDTO.class)); //lo pasamos a DTO porque debemos llenar la lista con esos
        }

        return estudianteDTO;
    }
}
