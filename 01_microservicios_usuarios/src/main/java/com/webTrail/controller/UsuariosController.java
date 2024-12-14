package com.webTrail.controller;

import com.webTrail.model.Usuario;
import com.webTrail.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController // Indica que la clase corresponde a un cotrolador REST
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    @GetMapping (value = "/autenticar", produces = MediaType.APPLICATION_JSON_VALUE ) // El método atenderá peticiones GET // Formato al que será convertido el objeto de respuesta
    public ResponseEntity<Usuario> autenticarUsuario (@RequestParam("correo") String correo, @RequestParam("password") String password){ // Mapeo de parametros usuario a parametros del metodo

        Usuario usuario =  usuariosService.autenticarUsuario(correo, password);
        if (usuario != null) {
            return ResponseEntity.ok(usuario); // Retorna 200 OK con el usuario
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Retorna 401 Unauthorized si no se encuentra
        }
    }

    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario){
        if (usuariosService.registrarUsuario(usuario)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
