package com.eam.RestaurantApp.controller;

import com.eam.RestaurantApp.entity.Factura;
import com.eam.RestaurantApp.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> listFacturas(@PageableDefault(size = 10, page = 0)Pageable pageable){
        return facturaService.listFacturas(pageable);
    }

    @GetMapping("/{idFactura}")
    public Factura find(@PathVariable ("idFactura") Integer idFactura){
        return facturaService.find(idFactura);
    }

    @PostMapping
    public void create(@RequestBody @Valid  Factura factura){
        facturaService.create(factura);
    }

    @PutMapping("/{idFactura}")
    public Factura update(@RequestBody @Valid Factura factura, @PathVariable("idFactura") Integer idFactura){
        return facturaService.update(idFactura, factura);
    }

    @DeleteMapping("/{idFactura}")
    public void delete(@PathVariable("idFactura") Integer idFactura){
        facturaService.delete(idFactura);
    }
}
