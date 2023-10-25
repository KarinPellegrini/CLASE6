package modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "materias")
public class Materia {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "materia")// como se llama la propiedad en el lado inverso de la relacion, es decir en cursada
    @JsonIgnore
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
}
