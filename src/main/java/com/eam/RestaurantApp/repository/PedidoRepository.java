package com.eam.RestaurantApp.repository;

import com.eam.RestaurantApp.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
