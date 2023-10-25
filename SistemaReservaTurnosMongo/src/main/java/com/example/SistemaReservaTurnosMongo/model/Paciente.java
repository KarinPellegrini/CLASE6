package com.dh.clinica.clientes.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Paciente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nombre;
  private String apellido;
  private String mail;
  private String dni;

  @OneToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "domicilio_id")
  private Domicilio domicilio;

  @OneToMany(mappedBy = "paciente")
  @JsonIgnore
  private Set<Turno> turno;
}
