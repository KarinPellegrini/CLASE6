package modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Estudiantes")
public class Estudiante {

    @Id //decimos que id va a ser nuestro id en la BDD
    @GeneratedValue //con esto el id se autogenera
    private Long id;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "estudiante") //el str "estudiante" hace referencia a como aparece el estudiante en la clase Cursada Porque un estudiante tiene muchas cursadas
    @JsonIgnore //Para ignorar en el json a cursadas
    private Set<Cursada> cursadas;

    public Set<Cursada> getCursadas() {
        return cursadas;
    }

    public void setCursadas(Set<Cursada> cursadas) {
        this.cursadas = cursadas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
