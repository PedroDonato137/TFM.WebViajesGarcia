package com.webTrail.service;

import com.webTrail.model.Continentes;
import com.webTrail.model.Viajes;

import java.util.List;

public interface ViajesService {
    List<Continentes> continente();
    List<Viajes> viajesPorContinente(int idContinente);
    Viajes actualizarCapacidad(int id_viaje, int unidades);
    Viajes viajePorCodigo (int id_viajes);
}
