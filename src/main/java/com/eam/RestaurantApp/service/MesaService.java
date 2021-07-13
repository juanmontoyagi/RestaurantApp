package com.eam.RestaurantApp.service;


import com.eam.RestaurantApp.entity.Mesa;
import com.eam.RestaurantApp.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MesaService {

    @Autowired
    MesaRepository mesaRepository;

    public List<Mesa> listaMesas(){
        return mesaRepository.findAll();
    }

    public Optional<Mesa> getMesa(int idMesa){
        return mesaRepository.findById(idMesa);
    }

    public Optional<Mesa> getByNumeroMesa(int numeroMesa){
        return mesaRepository.findByNumeroMesa(numeroMesa);
    }

    public void saveMesa(Mesa mesa){
        mesaRepository.save(mesa);
    }

    public void deleteMesa(int idMesa){
        mesaRepository.deleteById(idMesa);
    }

    public boolean existByIdMesa(int idMesa){
        return mesaRepository.existsById(idMesa);
    }

    public boolean existByNumeroMesa(int numeroMesa){
        return mesaRepository.existByNumeroMesa(numeroMesa);
    }
}
