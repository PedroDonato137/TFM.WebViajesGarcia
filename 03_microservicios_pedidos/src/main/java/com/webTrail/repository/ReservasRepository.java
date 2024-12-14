package com.webTrail.repository;


import com.webTrail.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservasRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByIdUsuario(int idUsuario);
}
