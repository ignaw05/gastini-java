package com.gastini.gastini.repository;

import com.gastini.gastini.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNombre(String categoriaNombre);
}
