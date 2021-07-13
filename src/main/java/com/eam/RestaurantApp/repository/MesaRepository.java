package com.eam.RestaurantApp.repository;

import com.eam.RestaurantApp.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {

    Optional<Mesa> findByNumeroMesa(int numeroMesa);
    boolean existByNumeroMesa(int numeroMesa);

}
