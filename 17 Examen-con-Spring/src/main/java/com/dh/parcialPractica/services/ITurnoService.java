package com.dh.parcialPractica.services;

import com.dh.parcialPractica.dto.PacienteDto;

import java.util.Set;

public interface IRestMethods<T> {
    void agregar(PacienteDto pacienteDto);
    PacienteDto leer(Long id);
    void modificar(PacienteDto pacienteDto);
    void eliminar(Long id);
    Set<PacienteDto> getTodos();
}
