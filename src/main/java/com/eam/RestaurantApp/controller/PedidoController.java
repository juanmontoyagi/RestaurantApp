package com.eam.RestaurantApp.controller;

import com.eam.RestaurantApp.entity.Pedido;
import com.eam.RestaurantApp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listPedidos(@PageableDefault(size = 10, page = 0)Pageable pageable){
        return pedidoService.listPedidos(pageable);
    }

    @GetMapping("/{idPedido}")
    public Pedido find(@PathVariable("idPedido") Integer idPedido){
        return pedidoService.find(idPedido);
    }

    @PostMapping
    public void create(@RequestBody @Valid Pedido pedido){
        pedidoService.create(pedido);
    }

    @PutMapping("/{idPedido}")
    public void update(@RequestBody @Valid Pedido pedido, @PathVariable("idPedido") Integer idPedido){
        pedidoService.update(idPedido, pedido);
    }

    @DeleteMapping("/{idPedido}")
    public void delete(@PathVariable("idPedido") Integer idPedido){
        pedidoService.delete(idPedido);
    }

}
