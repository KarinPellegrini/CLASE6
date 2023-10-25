package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import modelo.Estudiante;
import modelo.EstudianteDTO;
import modelo.Materia;
import modelo.MateriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IEstudianteRepository;
import repository.IMateriaRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MateriaService implements IMateriaService{

    @Autowired //para que el framework lo instancie
    private IMateriaRepository materiaRepository; //Para acceder a la capa de datos

    @Autowired
    ObjectMapper mapper;

    private void guardarMateria(MateriaDTO materiaDTO){
       Materia materia = mapper.convertValue(materiaDTO, Materia.class); //que nos convierta un estudianteDTO a un estudiante
       materiaRepository.save(materia);
    }
    @Override
    public void crearMateria(MateriaDTO materiaDTO) {
        guardarMateria(materiaDTO);
    }

    @Override
    public MateriaDTO leerMateria(Long id) {
        Optional<Materia> materia = materiaRepository.findById(id);
        //Optional nos permite preguntar si tiene o no un contenido
        MateriaDTO materiaDTO = null;
        if(materia.isPresent()){ //preguntamos si no es nulo
            materiaDTO = mapper.convertValue(materia, MateriaDTO.class);
        }

        return materiaDTO;
    }

    @Override
    public void modificarMateria(MateriaDTO materiaDTO) {
        guardarMateria(materiaDTO);
    }

    @Override
    public void eliminarMateria(Long id) {
        materiaRepository.deleteById(id);
    }

    @Override
    public Set<MateriaDTO> getTodos() {
        List<Materia> materias = materiaRepository.findAll();
        //Pero debemos devolver estudiantes DTO, entonces por cada estudiante llenamos un set de estuDTO
        Set<MateriaDTO> materiaDTOS = new HashSet<>();

        for(Materia materia:materias){
            materiaDTOS.add(mapper.convertValue(materia,MateriaDTO.class)); //lo pasamos a DTO porque debemos llenar la lista con esos
        }

        return materiaDTOS;
    }
}
