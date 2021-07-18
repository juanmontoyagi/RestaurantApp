package com.eam.RestaurantApp.controller;

import com.eam.RestaurantApp.entity.Rol;
import com.eam.RestaurantApp.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.web.PageableDefault;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> listRoles(@PageableDefault(size = 10, page = 0) Pageable pageable){
        return rolService.listRoles(pageable);
    }

    @GetMapping("/{idRol}")
    public Rol find(@PathVariable ("idRol") Integer idRol){
        return rolService.find(idRol);
    }

    @PostMapping("/crearRol")
    public void create(@RequestBody @Valid Rol rol){
        rolService.create(rol);
    }

    @PutMapping("/{idRol}")
    public void update(@RequestBody @Valid Rol rol, @PathVariable("idRol") Integer idRol){
        rolService.update(idRol, rol);
    }

    @DeleteMapping("/{idRol}")
    public void delete(@PathVariable("idRol") Integer idRol){
        rolService.delete(idRol);
    }

}
