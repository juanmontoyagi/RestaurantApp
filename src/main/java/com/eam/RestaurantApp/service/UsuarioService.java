package com.eam.RestaurantApp.service;

import com.eam.RestaurantApp.entity.Usuario;
import com.eam.RestaurantApp.exception.BusinessException;
import com.eam.RestaurantApp.exception.NotFoundException;
import com.eam.RestaurantApp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public List<Usuario> getAll(Pageable pageable){
        return usuarioRepository.findAll(pageable).getContent();
    }

    public List<Usuario> findByName(String nombreUsuario, Pageable pageable){
        return usuarioRepository.findByUserName("%"+nombreUsuario+"%", pageable);
    }

    public Usuario find(Integer idUsuario){
        boolean usuario = usuarioRepository.existsById(idUsuario);
        if (!usuario)
            throw new NotFoundException("No se encontró usuario con el ID "+idUsuario, "usuarios_doesnt_exist");
        return usuarioRepository.findById(idUsuario).get();
    }

    public Usuario update(Integer idUsuario, Usuario user){
        boolean usuario = usuarioRepository.existsById(idUsuario);
        if (!usuario) throw new NotFoundException("No se encontró usuario con el ID "+idUsuario, "usuarios_doesnt_exist");
        user.setIdUsuario(idUsuario);
        usuarioRepository.save(user);
        return user;
    }

}
