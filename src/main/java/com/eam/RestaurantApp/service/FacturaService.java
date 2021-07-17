package com.eam.RestaurantApp.service;

import com.eam.RestaurantApp.entity.Factura;
import com.eam.RestaurantApp.exception.NotFoundException;
import com.eam.RestaurantApp.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public Factura create(Factura f){
        boolean facturaExist = facturaRepository.existsById(f.getIdFactura());
        if (facturaExist) throw new RuntimeException("YA EXISTE EL PRODUCTO STORE");
        facturaRepository.save(f);
        return f;
    }

    public Factura find(Integer idFactura){
        boolean facturaBuscar = facturaRepository.existsById(idFactura);
        if (!facturaBuscar) throw new NotFoundException("NO SÉ ENCONTRÓ EL ID: "+idFactura, "factura_doesnt_exist");
        return facturaRepository.findById(idFactura).get();
    }


}
