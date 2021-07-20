package com.eam.RestaurantApp.controller;

import com.eam.RestaurantApp.entity.PedidoPlato;
import com.eam.RestaurantApp.service.PedidoPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedidos_platos")
public class PedidoPlatoController {

    @Autowired
    private PedidoPlatoService pedidoPlatoService;

    @GetMapping
    public List<PedidoPlato> listPedidosPlatos(@PageableDefault(size = 10, page = 0)Pageable pageable){
        return pedidoPlatoService.listPedidosPlatos(pageable);
    }

    @GetMapping("/{idPedidoPlato}")
    public PedidoPlato find(@PathVariable("idPedidoPlato") Integer idPedidoPlato){
        return pedidoPlatoService.find(idPedidoPlato);
    }

    @PostMapping
    public void create(@RequestBody @Valid PedidoPlato pedidoPlato){
        pedidoPlatoService.create(pedidoPlato);
    }

    @PutMapping("/{idPedidoPlato}")
    public PedidoPlato update(@RequestBody @Valid PedidoPlato pedidoPlato, @PathVariable("idPedidoPlato") Integer idPedidoPlata){
        return pedidoPlatoService.update(idPedidoPlata, pedidoPlato);
    }

    @DeleteMapping("/{idPedidoPlato}")
    public void delete(@PathVariable("idPedidoPlato") Integer idPedidoPlato){
        pedidoPlatoService.delete(idPedidoPlato);
    }
}
