package com.example.miProyecto.service;

import com.example.miProyecto.dominio.Paciente;

public class UsuarioService {

    public Paciente crearPaciente(){
        Paciente usuario = new Paciente("Karin",21);
        return usuario;
    }

}
