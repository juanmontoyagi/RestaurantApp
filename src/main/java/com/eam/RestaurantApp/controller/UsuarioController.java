package com.eam.RestaurantApp.controller;

import com.eam.RestaurantApp.entity.Usuario;
import com.eam.RestaurantApp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public void create(@RequestBody @Valid Usuario usuario){
        usuarioService.create(usuario);
    }
}
