package com.webTrail.repository;

import com.webTrail.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, String> {
    Usuario findByCorreoAndPassword(String correo, String password);
}
