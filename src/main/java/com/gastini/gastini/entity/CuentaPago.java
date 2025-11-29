package com.gastini.gastini.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class CuentaPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "cuenta_pago")
    private List<Gasto> gastos;

    @OneToMany(mappedBy = "cuenta_pago")
    private List<Ingreso> ingresos;
}
