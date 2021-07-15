package com.eam.RestaurantApp.controller;


import com.eam.RestaurantApp.dto.Mensaje;
import com.eam.RestaurantApp.dto.MesaDTO;
import com.eam.RestaurantApp.repository.MesaRepository;
import com.eam.RestaurantApp.service.MesaService;
import com.eam.RestaurantApp.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")

public class MesaController {

    @Autowired
    MesaService mesaService;

    @GetMapping("listarMesas")
    public List<Mesa> listaMesas(){
        return mesaService.listMesas();
    }

    @PostMapping("/crearMesa")
    public void save(@RequestBody Mesa mesa){
        mesaService.saveMesa(mesa);
    }

    @PutMapping("/{idMesa}")
    public void update(@RequestBody Mesa mesa, @PathVariable("idMesa") Integer idMesa){
        mesaService.update(idMesa, mesa);
    }

    @GetMapping("/{idMesa}")
    public Mesa find(@PathVariable("idMesa") Integer idMesa){
        return mesaService.find(idMesa);
    }

    @DeleteMapping("/{idMesa}")
    public void delete(@PathVariable("idMesa") Integer idMesa){
        mesaService.delete(idMesa);
    }

}
