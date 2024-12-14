package com.webTrail.service;

import com.webTrail.model.Usuario;

public interface UsuariosService {

    Usuario autenticarUsuario(String correo, String password); // Metodo para logear
    boolean registrarUsuario(Usuario usuario); // Metodo para comprobar que existe el usuario


}
