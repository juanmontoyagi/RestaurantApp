package com.eam.RestaurantApp.service;

import com.eam.RestaurantApp.entity.PedidoPlato;
import com.eam.RestaurantApp.exception.BusinessException;
import com.eam.RestaurantApp.exception.NotFoundException;
import com.eam.RestaurantApp.repository.PedidoPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoPlatoService {

    @Autowired
    private PedidoPlatoRepository pedidoPlatoRepository;

    public List<PedidoPlato> listPedidosPlatos(Pageable pageable){
        return pedidoPlatoRepository.findAll();
    }

    public PedidoPlato find(Integer idPedidoPlato){
        boolean pedidoPlatoExist = pedidoPlatoRepository.existsById(idPedidoPlato);
        if (!pedidoPlatoExist) throw new NotFoundException("El pedido_plato con el id: "+idPedidoPlato+" no existe", "doesnt_exist_pedidoPlato");
        return pedidoPlatoRepository.findById(idPedidoPlato).get();
    }

    public PedidoPlato create(PedidoPlato pedidoPlato){
        boolean pedidoPlatoExist = pedidoPlatoRepository.existsById(pedidoPlato.getIdPedido());
        if (pedidoPlatoExist) throw new BusinessException("El pedido con ese id: "+pedidoPlato.getIdPedidoPlato()+" ya existe", "pedido_exist");
        pedidoPlatoRepository.save(pedidoPlato);
        return pedidoPlato;
    }

    public PedidoPlato update(Integer idPedidoPlato, PedidoPlato pedidoPlato){
        boolean pedidoPlatoExist = pedidoPlatoRepository.existsById(idPedidoPlato);
        if (!pedidoPlatoExist) throw new BusinessException("El pedido con ese id: "+idPedidoPlato+" ya existe", "pedido_exist");
        pedidoPlato.setIdPedidoPlato(idPedidoPlato);
        pedidoPlatoRepository.save(pedidoPlato);
        return pedidoPlato;
    }

    public void delete(Integer idPedidoPlato){
        boolean pedidoPlatoExist = pedidoPlatoRepository.existsById(idPedidoPlato);
        if (!pedidoPlatoExist) throw new BusinessException("El pedido con ese id: "+idPedidoPlato+" ya existe", "pedido_exist");
        pedidoPlatoRepository.deleteById(idPedidoPlato);
    }
}
