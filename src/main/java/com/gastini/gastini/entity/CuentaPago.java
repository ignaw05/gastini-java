package com.gastini.gastini.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class CuentaPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "cuentaPago")
    @JsonIgnore
    private List<Gasto> gastos;

    
    @OneToMany(mappedBy = "cuentaPago")
    @JsonIgnore
    private List<Ingreso> ingresos;
}
