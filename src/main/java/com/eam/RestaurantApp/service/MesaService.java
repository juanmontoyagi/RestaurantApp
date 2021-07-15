package com.eam.RestaurantApp.service;


import com.eam.RestaurantApp.entity.Mesa;
import com.eam.RestaurantApp.exception.BusinessException;
import com.eam.RestaurantApp.exception.NotFoundException;
import com.eam.RestaurantApp.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MesaService {

    @Autowired
    MesaRepository mesaRepository;

   public List<Mesa> listMesas(Pageable pageable){
        return mesaRepository.findAll();
    }

    public Mesa saveMesa(Mesa mesa){
        boolean mesaValidate = mesaRepository.existsById(mesa.getIdMesa());
        if (mesaValidate)
            throw new BusinessException("Ya existe la mesa con el ID: "+mesa.getIdMesa(), "mesa_exist");
        mesaRepository.save(mesa);
        return mesa;
    }

    public Mesa find(Integer idMesa){
       boolean mesa = mesaRepository.existsById(idMesa);
       if (!mesa)
           throw new NotFoundException("No existe una mesa con el ID: "+idMesa, "mesa_doesnt_exist");
       return mesaRepository.findById(idMesa).get();
    }

    public Mesa update(Integer idMesa, Mesa m){
       boolean mesa = mesaRepository.existsById(idMesa);
       if (!mesa)
           throw new NotFoundException("No existe una mesa con el ID: "+idMesa, "mesa_doesnt_exist");
       m.setIdMesa(idMesa);
       mesaRepository.save(m);
       return m;
    }

    public void delete(Integer idMesa){
       boolean mesa = mesaRepository.existsById(idMesa);
       if (!mesa)
           throw new NotFoundException("No existe una mesa con el ID: "+idMesa, "mesa_doesnt_exist");
       mesaRepository.deleteById(idMesa);
    }
/*
    public Mesa findMesa(Integer numeroMesa){
        boolean mesaNumero = mesaRepository.findByNumeroMesa(numeroMesa);
        if (!mesaNumero)
            System.out.println("No existe.");
        return mesaRepository.findByNumeroMesa(numeroMesa).getNumeroMesa();
    } */

}
