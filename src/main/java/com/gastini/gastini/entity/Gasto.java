package com.gastini.gastini.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;
    private String descripcion;

    private double monto;
    private double tax;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private CuentaPago cuentaPago;
}
