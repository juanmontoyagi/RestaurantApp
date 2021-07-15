package com.eam.RestaurantApp.repository;

import com.eam.RestaurantApp.entity.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE LOWER(u.nombreUsuario) LIKE LOWER(:nombreUsuario)")
    List<Usuario> findByUserName(String nombreUsuario, Pageable pageable);

}
