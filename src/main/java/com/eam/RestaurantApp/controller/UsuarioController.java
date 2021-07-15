package com.eam.RestaurantApp.controller;

import com.eam.RestaurantApp.entity.Usuario;
import com.eam.RestaurantApp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{idUsuario}")
    public Usuario find(@PathVariable("idUsuario") Integer idUsuario){
        return usuarioService.find(idUsuario);
    }

    @GetMapping
    public List<Usuario> getAll(@PageableDefault(size = 10, page = 0) Pageable pageable){
        return usuarioService.getAll(pageable);
    }

    @GetMapping("/findByName/{nombreUsuario}")
    public List<Usuario> findByName(@PathVariable("nombreUsuario") String nombreUsuario,
                                    @PageableDefault(size = 10, page = 0) Pageable pageable){
        return usuarioService.findByName(nombreUsuario, pageable);
    }

    @PostMapping
    public void create(@RequestBody @Valid Usuario usuario){
        usuarioService.create(usuario);
    }

    @PutMapping("/{idUsuario}")
    public void update(@RequestBody @Valid Usuario usuario, @PathVariable("idUsuario") Integer idUsuario){
        usuarioService.update(idUsuario, usuario);
    }
}
