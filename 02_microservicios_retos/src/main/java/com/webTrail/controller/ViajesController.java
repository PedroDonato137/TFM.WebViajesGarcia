package com.webTrail.controller;

import com.webTrail.model.Continentes;
import com.webTrail.model.Viajes;
import com.webTrail.service.ViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ViajesController {
    @Autowired
    ViajesService viajesService;

    @GetMapping(value = "/continentes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Continentes>> getContinente(){
        return new ResponseEntity<>(viajesService.continente(), HttpStatus.OK);
    }

    @GetMapping(value = "/viajes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Viajes>> getViajesContinente(@RequestParam("idContinente") int idContinente){
        return new ResponseEntity<>(viajesService.viajesPorContinente(idContinente), HttpStatus.OK);
    }

    @GetMapping(value = "/viaje", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Viajes> getViajesPorCodigo(@RequestParam("id_viajes") int id_viajes){
        return new ResponseEntity<>(viajesService.viajePorCodigo(id_viajes), HttpStatus.OK);
    }

    @PutMapping(value = "/viaje")
    public ResponseEntity<Void> actualizarCapacidad(@RequestParam("id_viajes") int id_viajes, @RequestParam("unidades") int unidades){
        Viajes viaje = viajesService.actualizarCapacidad(id_viajes, unidades);
        if(viaje != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}