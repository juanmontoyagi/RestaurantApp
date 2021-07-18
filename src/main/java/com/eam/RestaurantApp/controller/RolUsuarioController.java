package com.eam.RestaurantApp.controller;

import com.eam.RestaurantApp.entity.RolUsuario;
import com.eam.RestaurantApp.service.RolUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/roles_usuarios")
public class RolUsuarioController {

    @Autowired
    private RolUsuarioService rolUsuarioService;

    @GetMapping("/{idRolUsuario}")
    private RolUsuario find(@PathVariable("idRolUsuario") Integer idRolUsuario){
        return rolUsuarioService.find(idRolUsuario);
    }

    @PostMapping
    private void create(@RequestBody @Valid RolUsuario rolUsuario){
        rolUsuarioService.create(rolUsuario);
    }
/* PARA QUÉ ACTUALIZAR, SE PUEDE BORRAR Y VOLVER A ASIGNARLE EL ROL
    @PutMapping("/{idRolUsuario}")
    private void update(@PathVariable("idRolUsuario") Integer idRolUsuario, @RequestBody RolUsuario rolUsuario){
        rolUsuarioService.update(idRolUsuario, rolUsuario);
    }
*/
    @DeleteMapping("/{idRolUsuario}")
    private void delete(@PathVariable("idRolUsuario") Integer idRolUsuario){
        rolUsuarioService.delete(idRolUsuario);
    }
}
