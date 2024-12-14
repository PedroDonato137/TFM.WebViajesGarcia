package com.webTrail.service;

import com.webTrail.model.ElementosReserva;
import com.webTrail.model.Reserva;

import java.util.List;

public interface ReservasService {

    List<Reserva> reservasUsuario(int idUsuario);
    Reserva guardarReserva(List<ElementosReserva> elementosReservas, int idUsuario);

}
