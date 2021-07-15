package com.eam.RestaurantApp.service;

import com.eam.RestaurantApp.entity.Usuario;
import com.eam.RestaurantApp.exception.BusinessException;
import com.eam.RestaurantApp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario create(Usuario user){
        boolean usuario = usuarioRepository.existsById(user.getIdUsuario());
        if (usuario)
            throw new BusinessException("Ya existe el usuario con el ID: "+user.getIdUsuario(), "usuario_exist");
        usuarioRepository.save(user);
        return user;
    }

}
