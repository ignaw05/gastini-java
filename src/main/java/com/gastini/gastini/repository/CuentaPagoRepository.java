package com.gastini.gastini.repository;

import com.gastini.gastini.entity.CuentaPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaPagoRepository extends JpaRepository<CuentaPago, Long> {
    CuentaPago findByNombre(String cuentaPago);
}
