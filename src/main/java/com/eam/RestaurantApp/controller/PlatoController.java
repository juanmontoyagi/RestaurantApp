package com.eam.RestaurantApp.controller;

import com.eam.RestaurantApp.entity.Plato;
import com.eam.RestaurantApp.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @GetMapping
    public List<Plato> listFacturas(@PageableDefault(size = 10, page = 0)Pageable pageable){
        return platoService.listPlatos(pageable);
    }

    @GetMapping("/{idPlato}")
    public Plato find(@PathVariable("idPlato") Integer idPlato){
        return platoService.find(idPlato);
    }

    @PostMapping
    public Plato create(@RequestBody @Valid Plato plato){
        return platoService.create(plato);
    }

    @PutMapping("/{idPlato}")
    public Plato update(@RequestBody @Valid Plato plato, @PathVariable("idPlato") Integer idPlato){
        return platoService.update(idPlato, plato);
    }

    @DeleteMapping("/{idPlato}")
    public void delete(@PathVariable("idPlato") Integer idPlato){
        platoService.delete(idPlato);
    }
}
