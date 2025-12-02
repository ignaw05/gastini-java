package com.gastini.gastini.repository;

import com.gastini.gastini.entity.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiendaRepository extends JpaRepository<Tienda, Long> {
    Tienda findByNombre(String tiendaNombre);
}
