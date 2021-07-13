package com.eam.RestaurantApp.controller;


import com.eam.RestaurantApp.dto.Mensaje;
import com.eam.RestaurantApp.dto.MesaDTO;
import com.eam.RestaurantApp.service.MesaService;
import com.eam.RestaurantApp.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")

public class MesaController {

    @Autowired
    MesaService mesaService;

    @GetMapping("listarMesas")
    public ResponseEntity<List<Mesa>> listarMesas(){
        List<Mesa> mesas = mesaService.listaMesas();
        return new ResponseEntity<List<Mesa>>(mesas, HttpStatus.OK);
    }

    @GetMapping("/detalleMesa/{idMesa}")
    public ResponseEntity<Mesa> mesaById(@PathVariable("idMesa") int idMesa){
        if (!mesaService.existByIdMesa(idMesa))
            return new ResponseEntity(new Mensaje("No se encontro id con esa mesa"), HttpStatus.NOT_FOUND);

        Mesa mesa = mesaService.getMesa(idMesa).get();
        return new ResponseEntity(mesa, HttpStatus.OK);
    }

    @GetMapping("/detalleMesa/{numeroMesa}")
    public ResponseEntity<Mesa> mesaByNumeroMesa(@PathVariable("numeroMesa") int numeroMesa){
        if (!mesaService.existByNumeroMesa(numeroMesa))
            return new ResponseEntity(new Mensaje("No se encontro el numero con esa mesa"), HttpStatus.NOT_FOUND);

        Mesa mesa = mesaService.getByNumeroMesa(numeroMesa).get();
        return new ResponseEntity(mesa, HttpStatus.OK);
    }

    @PostMapping("/crearMesa")
    public ResponseEntity<?> crearMesa(@RequestBody MesaDTO mesaDTO){
        if (mesaService.existByNumeroMesa(mesaDTO.getNumeroMesa()))
            return new ResponseEntity(new Mensaje("Ya existe una mesa con ese numero"), HttpStatus.BAD_REQUEST);

        Mesa mesa = new Mesa(mesaDTO.getNumeroMesa(), mesaDTO.isEstadoMesa());
        mesaService.saveMesa(mesa);
        return new ResponseEntity(new Mensaje("Se guardo la mesa con exito"), HttpStatus.OK);
    }

    @PutMapping("/actualizarMesa/{idMesa}")
    public ResponseEntity<?> actualizarMesa(@PathVariable("idMesa") int idMesa, @RequestBody MesaDTO mesaDTO){
        if (!mesaService.existByIdMesa(idMesa))
            return new ResponseEntity(new Mensaje("No existe mesa con ese id"), HttpStatus.NOT_FOUND);

        if (mesaService.existByNumeroMesa(mesaDTO.getNumeroMesa())
        && mesaService.getByNumeroMesa(mesaDTO.getNumeroMesa()).get().getIdMenu() != idMesa)
            return new ResponseEntity(new Mensaje("El numero de la mesa ya existe"), HttpStatus.NOT_FOUND);

        Mesa mesa = mesaService.getMesa(idMesa).get();
        mesa.setNumeroMesa(mesaDTO.getNumeroMesa());
        mesa.setEstadoMesa(mesaDTO.isEstadoMesa());
        mesaService.saveMesa(mesa);
        return new ResponseEntity(new Mensaje("Mesa actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/borrarMesa/{idMesa}")
    public ResponseEntity<?> borrarMesa(@PathVariable("idMesa") int idMesa){
        if (!mesaService.existByIdMesa(idMesa))
            return new ResponseEntity(new Mensaje("No existe la torre"), HttpStatus.NOT_FOUND);
            mesaService.deleteMesa(idMesa);
            return new ResponseEntity(new Mensaje("Mesa eliminada"), HttpStatus.OK);
    }

}
