package com.webTrail.service;

import com.webTrail.model.Usuario;
import com.webTrail.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Para que Spring instancie la clase
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired // Inyección de dependencia
    UsuariosRepository usuariosRepository;

    /**
     * Metodo para buscar al usuario por su correo y su contraseña
     * si lo encuentra lo devuelve
     *
     * @param correo
     * @param password
     * @return el usuario encontrado
     */
    @Override
    public Usuario autenticarUsuario(String correo, String password) {

        return usuariosRepository.findByCorreoAndPassword(correo, password);
    }

    /**
     * Metodo para indicar que el usuario se a registrado o no
     * @param usuario
     * @return Devuelve un boolean
     */
    @Override
    public boolean registrarUsuario(Usuario usuario) {
        if (usuariosRepository.findById(String.valueOf(usuario.getId_usuario())).isPresent()){ // Comprueba que el usuario exista
            return false;
        }
        usuariosRepository.save(usuario); // Guardar nuevo usuario
        return true;
    }
}
