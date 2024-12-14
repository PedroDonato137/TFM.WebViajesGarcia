package com.webTrail.controller;

import com.webTrail.model.ElementosReserva;
import com.webTrail.model.Reserva;
import com.webTrail.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ReservasController {
    @Autowired
    ReservasService reservasService;

    @GetMapping(value = "/reservas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reserva>> reservasUsuario (@RequestParam ("idUsuario") int idUsuario){
        return new ResponseEntity<>(reservasService.reservasUsuario(idUsuario), HttpStatus.OK);
    }

    @PostMapping(value = "/reserva", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> guardarReserva(@RequestBody List<ElementosReserva> elementosReservas, @RequestParam ("idUsuario") int idUsuario){
        Reserva reserva = reservasService.guardarReserva(elementosReservas, idUsuario);
        if(reserva != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

}
