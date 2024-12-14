package com.webTrail.repository;

import com.webTrail.model.Viajes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Declaracion del metodo para buscar los viajes por el id del continente
 */
public interface ViajesRepository extends JpaRepository<Viajes, Integer> {
    List<Viajes> findByIdContinente (int idContinente);
}
