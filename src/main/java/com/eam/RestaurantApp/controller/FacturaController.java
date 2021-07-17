package com.eam.RestaurantApp.controller;

import com.eam.RestaurantApp.entity.Factura;
import com.eam.RestaurantApp.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/{idFactura}")
    public Factura find(@PathVariable ("idFactura") Integer idFactura){
        return facturaService.find(idFactura);
    }

    @PostMapping
    public void create(@RequestBody Factura fa){
        facturaService.create(fa);
    }
}
