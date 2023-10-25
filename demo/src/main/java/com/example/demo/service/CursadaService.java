package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import modelo.Cursada;
import modelo.CursadaDTO;
import modelo.Estudiante;
import modelo.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ICursadaRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CursadaService implements ICursadaService {

    @Autowired
    private ICursadaRepository cursadaRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarCursada(CursadaDTO cursadaDTO){
        Cursada cursada = mapper.convertValue(cursadaDTO,Cursada.class); //que nos convierta un estudianteDTO a un estudiante
        cursadaRepository.save(cursada);
    }

    @Override
    public void crearCursada(CursadaDTO cursadaDTO) {
        guardarCursada(cursadaDTO);
    }

    @Override
    public CursadaDTO leerCursada(Long id) {
        Optional<Cursada> cursada = cursadaRepository.findById(id);
        //Optional nos permite preguntar si tiene o no un contenido
        CursadaDTO cursadaDTO = null;
        if(cursada.isPresent()){ //preguntamos si no es nulo
            cursadaDTO = mapper.convertValue(cursada, CursadaDTO.class);
        }

        return cursadaDTO;
    }

    @Override
    public void modificarCursada(CursadaDTO cursadaDTO) {
        guardarCursada(cursadaDTO);
    }

    @Override
    public void eliminarCursada(Long id) {
        cursadaRepository.deleteById(id);
    }

    @Override
    public Set<CursadaDTO> getTodos() {
        List<Cursada> cursadas = cursadaRepository.findAll();
        //Pero debemos devolver estudiantes DTO, entonces por cada estudiante llenamos un set de estuDTO
        Set<CursadaDTO> cursadaDTOS = new HashSet<>();
        for(Cursada cursada:cursadas){
            cursadaDTOS.add(mapper.convertValue(cursada,CursadaDTO.class)); //lo pasamos a DTO porque debemos llenar la lista con esos
        }

        return cursadaDTOS;
    }
}
