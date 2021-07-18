package com.eam.RestaurantApp.service;

import com.eam.RestaurantApp.entity.Rol;
import com.eam.RestaurantApp.entity.RolUsuario;
import com.eam.RestaurantApp.exception.BusinessException;
import com.eam.RestaurantApp.exception.NotFoundException;
import com.eam.RestaurantApp.repository.RolUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RolUsuarioService {

    @Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    public void create(RolUsuario rolUsuario){
        boolean rolUsuarioExist = rolUsuarioRepository.existsById(rolUsuario.getIdRol());
        if (rolUsuarioExist) throw new BusinessException("Ya existe un rolUsuario con ese id", "rolUsuario_exist");
        rolUsuarioRepository.save(rolUsuario);
    }

    public RolUsuario find(Integer idRolUsuario){
        boolean rolUsuarioExist = rolUsuarioRepository.existsById(idRolUsuario);
        if (!rolUsuarioExist) throw new NotFoundException("No existe el RolUsuario con ese ID", "rolUsuario_doesnt_exist");
        return rolUsuarioRepository.findById(idRolUsuario).get();
    }

    public RolUsuario update(Integer idRolUsuario, RolUsuario rolUsuario){
        boolean rolUsuarioExist = rolUsuarioRepository.existsById(idRolUsuario);
        if (!rolUsuarioExist) throw new NotFoundException("No existe el RolUsuario con ese ID", "rolUsuario_doesnt_exist");
        rolUsuario.setIdUsuario(idRolUsuario);
        rolUsuarioRepository.save(rolUsuario);
        return rolUsuario;
    }

    public void delete(Integer idRolUsuario){
        boolean rolUsuarioExist = rolUsuarioRepository.existsById(idRolUsuario);
        if (!rolUsuarioExist) throw new NotFoundException("No existe el RolUsuario con ese ID", "rolUsuario_doesnt_exist");
        rolUsuarioRepository.deleteById(idRolUsuario);
    }


}
