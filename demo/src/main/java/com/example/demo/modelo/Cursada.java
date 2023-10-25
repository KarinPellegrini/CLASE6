package modelo;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursadas")
public class Cursada {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne //Porque en estudiantes es @OneToMany
    @JoinColumn(name="estudiante_id", nullable = false) //creamos el nombre de un id para los estudiantes
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;
    private double nota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
