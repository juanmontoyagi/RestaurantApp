package com.eam.RestaurantApp.service;

import com.eam.RestaurantApp.entity.Plato;
import com.eam.RestaurantApp.exception.BusinessException;
import com.eam.RestaurantApp.exception.NotFoundException;
import com.eam.RestaurantApp.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    public List<Plato> listPlatos(Pageable pageable){
        return platoRepository.findAll();
    }

    public Plato find(Integer idPlato){
        boolean platoExist = platoRepository.existsById(idPlato);
        if (!platoExist) throw new NotFoundException("No se encontró el id: "+idPlato, "plato_doesnt_exist");
        return platoRepository.findById(idPlato).get();
    }

    public Plato create(Plato plato){
        boolean platoExist = platoRepository.existsById(plato.getIdPlato());
        if (platoExist) throw new BusinessException("Ya existe plato con ese id: "+ plato.getIdPlato(), "plato_exist");
        platoRepository.save(plato);
        return plato;
    }

    public Plato update(Integer idPlato, Plato plato){
        boolean platoExist = platoRepository.existsById(idPlato);
        if (!platoExist) throw new NotFoundException("No se encontró el id: "+idPlato, "plato_doesnt_exist");
        plato.setIdPlato(idPlato);
        platoRepository.save(plato);
        return plato;
    }

    public void delete(Integer idPlato){
        boolean platoExist = platoRepository.existsById(idPlato);
        if (!platoExist) throw new NotFoundException("No se encontró el id: "+idPlato, "plato_doesnt_exist");
        platoRepository.deleteById(idPlato);
    }
}
