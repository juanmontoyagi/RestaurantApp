package com.eam.RestaurantApp.repository;

import com.eam.RestaurantApp.entity.PedidoPlato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoPlatoRepository extends JpaRepository<PedidoPlato, Integer> {
}
