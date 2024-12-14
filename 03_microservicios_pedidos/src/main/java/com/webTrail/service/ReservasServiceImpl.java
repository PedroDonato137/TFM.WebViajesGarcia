package com.webTrail.service;

import com.webTrail.model.ElementosReserva;
import com.webTrail.model.Reserva;
import com.webTrail.repository.ElementosReservasRepository;
import com.webTrail.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.List;

@Service
public class ReservasServiceImpl implements ReservasService{

    String urlReservas = "http://localhost:8001/";

    @Autowired
    RestClient restClient;

    @Autowired
    ReservasRepository reservasRepository;

    @Autowired
    ElementosReservasRepository elementosReservasRepository;


    @Override
    public List<Reserva> reservasUsuario(int idUsuario) {
        return reservasRepository.findByIdUsuario(idUsuario);
    }

    @Override
    public Reserva guardarReserva(List<ElementosReserva> elementosReservas, int idUsuario) {
        try {
            // creacion objeto Reserva y lo guardo
            Reserva reserva = new Reserva(0, idUsuario, new Date(), "pendiente", null);
            Reserva r = reservasRepository.save(reserva);

            // Guardar los objetos ElementosReservas
            elementosReservas.forEach(e-> {
                e.setId_reservas(r.getId_reservas());
                e.setUnidades(e.getUnidades());
                elementosReservasRepository.save(e);
                // Ademas de guardar el elementosReserva, actualiza la capacidad
                // del viaje correspondiente llamando al recurso
                // del microservicio 02
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlReservas + "viaje")
                        .queryParam("Id_viajes", e.getViajes().getId_viajes())
                        .queryParam("unidades", e.getUnidades());

                restClient.put().uri(builder.toUriString()).retrieve();
            });
            return reserva;
        }catch (Exception e){
            return null;
        }
    }
}
