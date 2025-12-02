package com.gastini.gastini.repository;

import com.gastini.gastini.entity.Categoria;
import com.gastini.gastini.entity.CuentaPago;
import com.gastini.gastini.entity.Gasto;
import com.gastini.gastini.entity.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
    List<Gasto> findByCategoria(Categoria categoria);

    List<Gasto> findByTienda(Tienda tienda);

    List<Gasto> findByCuentaPago(CuentaPago cuentaPago);

}
