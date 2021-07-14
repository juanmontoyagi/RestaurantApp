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
        return mesaService.listarMesas();
    }

    @PostMapping("/crearMesa")
    public void crearMesa(@RequestBody Mesa mesa){
        mesaService.saveMesa(mesa);
    }

}
