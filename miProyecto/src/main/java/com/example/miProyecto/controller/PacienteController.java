package com.example.miProyecto.controller;

import com.example.miProyecto.dominio.Paciente;
import com.example.miProyecto.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    private UsuarioService usuarioService = new UsuarioService();

    @GetMapping("/")
    public Paciente crearUsuario(){
        return usuarioService.crearUsuario();
    }

    @GetMapping("crear2")
    public Paciente crearUsuario2(){
        Paciente user = new Paciente("Pablo",30);
        return user;
    }
}
