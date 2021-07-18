package com.eam.RestaurantApp.service;

import com.eam.RestaurantApp.entity.Rol;
import com.eam.RestaurantApp.exception.BusinessException;
import com.eam.RestaurantApp.exception.NotFoundException;
import com.eam.RestaurantApp.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listRoles(Pageable pageable){
        return rolRepository.findAll();
    }

    public void create(Rol rol){
        boolean rolExist = rolRepository.existsById(rol.getIdRol());
        if (rolExist) throw new BusinessException("Ya existe rol con el id: "+rol.getIdRol(), "rol_exist");
        rolRepository.save(rol);
    }

    public Rol find(Integer idRol){
        boolean rolExist = rolRepository.existsById(idRol);
        if (!rolExist) throw new NotFoundException("El id ingresado no: "+idRol+" no existe", "rol_doesnt_exist");
        return rolRepository.findById(idRol).get();
    }

    public Rol update(Integer idRol, Rol rol){
        boolean rolExist = rolRepository.existsById(idRol);
        if (!rolExist) throw new NotFoundException("El id ingresado: "+idRol+" no existe", "rol_doesnt_exist");
        rol.setIdRol(idRol);
        rolRepository.save(rol);
        return rol;
    }

    public void delete(Integer idRol){
        boolean rolExist = rolRepository.existsById(idRol);
        if (!rolExist) throw new NotFoundException("El id ingresado: "+idRol+" no existe", "rol_doesnt_exist");
        rolRepository.deleteById(idRol);
    }

}
