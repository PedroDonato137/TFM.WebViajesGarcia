package com.webTrail.repository;

import com.webTrail.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Metodo para buscar a un usuario por su correo, para la accion de logueo
 */
public interface UsuariosRepository extends JpaRepository<Usuario, String> {
    // El metodo findBy puede crearse automanticamente y buscar por los campos que quieras
    Usuario findByCorreoAndPassword(String correo, String password);
}
