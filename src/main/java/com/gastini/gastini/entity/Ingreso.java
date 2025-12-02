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
public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monto;
    private Double tax;
    private String descripcion;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private CuentaPago cuentaPago;
}
