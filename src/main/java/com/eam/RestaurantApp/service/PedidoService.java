package com.eam.RestaurantApp.service;

import com.eam.RestaurantApp.entity.Pedido;
import com.eam.RestaurantApp.exception.BusinessException;
import com.eam.RestaurantApp.exception.NotFoundException;
import com.eam.RestaurantApp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listPedidos(Pageable pageable){
        return pedidoRepository.findAll();
    }

    public Pedido find(Integer idPedido){
        boolean pedidoExist = pedidoRepository.existsById(idPedido);
        if (!pedidoExist) throw new NotFoundException("No existe pedido con el id: "+idPedido, " doesnt_exist_pedido");
        return pedidoRepository.findById(idPedido).get();
    }

    public Pedido create(Pedido pedido){
        boolean pedidoExist = pedidoRepository.existsById(pedido.getIdPedido());
        if (pedidoExist) throw new BusinessException("Ya existe el pedido con ese id: "+pedido.getIdPedido(), " pedido_exist");
        pedidoRepository.save(pedido);
        return pedido;
    }

    public Pedido update(Integer idPedido, Pedido pedido){
        boolean pedidoExist = pedidoRepository.existsById(idPedido);
        if (!pedidoExist) throw new NotFoundException("No existe pedido con el id: "+idPedido, " doesnt_exist_pedido");
        pedido.setIdPedido(idPedido);
        pedidoRepository.save(pedido);
        return pedido;
    }

    public void delete(Integer idPedido){
        boolean pedidoExist = pedidoRepository.existsById(idPedido);
        if (!pedidoExist) throw new NotFoundException("No existe pedido con el id: "+idPedido, " doesnt_exist_pedido");
        pedidoRepository.deleteById(idPedido);
    }

}
