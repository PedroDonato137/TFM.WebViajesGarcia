package com.webTrail.repository;


import com.webTrail.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Busca por id de usuario todas las reservas que tiene
 */
public interface ReservasRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByIdUsuario(int idUsuario);
}
