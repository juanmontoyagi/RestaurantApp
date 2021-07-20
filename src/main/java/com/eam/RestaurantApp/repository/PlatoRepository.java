package com.eam.RestaurantApp.repository;

import com.eam.RestaurantApp.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer> {
}
