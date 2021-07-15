package com.eam.RestaurantApp.controller;


import com.eam.RestaurantApp.service.MesaService;
import com.eam.RestaurantApp.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mesa")

public class MesaController {

    @Autowired
    MesaService mesaService;

    @GetMapping("listarMesas")
    public List<Mesa> listaMesas(@PageableDefault(size = 10, page = 0) Pageable pageable){
        return mesaService.listMesas(pageable);
    }

    @GetMapping("/{idMesa}")
    public Mesa find(@PathVariable("idMesa") Integer idMesa){
        return mesaService.find(idMesa);
    }

    @PostMapping("/crearMesa")
    public void save(@RequestBody @Valid Mesa mesa){
        mesaService.saveMesa(mesa);
    }

    @PutMapping("/{idMesa}")
    public void update(@RequestBody @Valid Mesa mesa, @PathVariable("idMesa") Integer idMesa){
        mesaService.update(idMesa, mesa);
    }

    @DeleteMapping("/{idMesa}")
    public void delete(@PathVariable("idMesa") Integer idMesa){
        mesaService.delete(idMesa);
    }

}
