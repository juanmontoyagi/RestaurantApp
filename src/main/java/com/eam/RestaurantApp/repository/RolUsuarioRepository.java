package com.eam.RestaurantApp.repository;

import com.eam.RestaurantApp.entity.RolUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Integer> {
/*
    @Query("SELECT r FROM roles_usuarios r WHERE r.ROL_idRol = :idRol")
    Page<RolUsuario> buscarRolId(Integer idRol, Pageable pageable);

    @Query("SELECT u FROM roles_usuarios u WHERE u.USUARIO_idUsuario = :idUsuario")
    Page<RolUsuario> buscarUsuarioId(Integer idUsuario, Pageable pageable);
*/
}
