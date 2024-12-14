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


    /**
     * Este metodo busca todos los continentes
     * @return una lista de continentes
     */
    @Override
    public List<Continentes> continente() {
        return continentesRepository.findAll();
    }

    /**
     * Este metodo busca por id de continente los viajes que hay
     * @param idContinente id del continente a buscar
     * @return una lista de viajes
     */
    @Override
    public List<Viajes> viajesPorContinente(int idContinente) {
        return viajesRepository.findByIdContinente(idContinente);
    }

    /**
     * Este metodo sirve para actualizar/validar la capacidad de los viajes
     * @param id_viaje identificador del viaje que buscamos
     * @param unidades Unidades de pasajeros que hay que restar
     * @return los datos del viaje actualizado (pasajeros)
     */
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

    /**
     * Busca los viajes por su identificador
     * @param id_viajes identificador del viaje que queremos buscar
     * @return los datos del viaje
     */
    @Override
    public Viajes viajePorCodigo(int id_viajes) {
        return viajesRepository.findById(id_viajes).orElse(null);
    }
}
