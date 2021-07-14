package com.eam.RestaurantApp.service;


import com.eam.RestaurantApp.entity.Mesa;
import com.eam.RestaurantApp.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MesaService {

    @Autowired
    MesaRepository mesaRepository;

   public List<Mesa> listarMesas(){
        return mesaRepository.findAll();
    }

    public Mesa saveMesa(Mesa mesa){
        boolean mesaValidate = mesaRepository.existsById(mesa.getIdMesa());
        if (mesaValidate)
            System.out.println("Ya existe.");
        mesaRepository.save(mesa);
        return mesa;
    }

}
