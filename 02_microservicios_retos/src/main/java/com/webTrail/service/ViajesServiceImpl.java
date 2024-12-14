package com.webTrail.service;

import com.webTrail.model.Continentes;
import com.webTrail.model.Viajes;
import com.webTrail.repository.ContinentesRepository;
import com.webTrail.repository.ViajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajesServiceImpl implements ViajesService {

    @Autowired
    ContinentesRepository continentesRepository;

    @Autowired
    ViajesRepository viajesRepository;


    @Override
    public List<Continentes> continente() {
        return continentesRepository.findAll();
    }

    @Override
    public List<Viajes> viajesPorContinente(int idContinente) {
        return viajesRepository.findByIdContinente(idContinente);
    }

    @Override
    public Viajes actualizarCapacidad(int id_viaje, int unidades) {
        Viajes viaje = viajePorCodigo(id_viaje);
        if(viaje != null && viaje.getCapacidad()>=unidades){
            viaje.setCapacidad(viaje.getCapacidad() - unidades);
            viajesRepository.save(viaje);
            return viaje;
        }
        return null;
    }

    @Override
    public Viajes viajePorCodigo(int id_viajes) {
        return viajesRepository.findById(id_viajes).orElse(null);
    }
}
