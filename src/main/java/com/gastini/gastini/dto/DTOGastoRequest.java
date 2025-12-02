package com.gastini.gastini.dto;

import com.gastini.gastini.entity.Categoria;
import com.gastini.gastini.entity.CuentaPago;
import com.gastini.gastini.entity.Gasto;
import com.gastini.gastini.entity.Tienda;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema
public class DTOGastoRequest {

    @NotNull(message = "La descripcion no puede ser nula")
    @NotEmpty(message = "La descripcion no puede estar vacia")
    @Size(min = 3, max = 255, message = "La descripcion debe tener entre 3 y 255 caracteres")
    private String descripcion;

    @NotNull(message = "El monto no puede ser nulo")
    @DecimalMin(value = "0.01", message = "El monto minimo es 0.01")
    private Double monto;

    @NotNull(message = "La fecha no puede ser nula")
    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd['T'HH:mm:ss]")
    private LocalDateTime fecha;

    @NotNull(message = "La categoria no puede ser nula")
    @NotEmpty(message = "La categoria no puede estar vacia")
    private String categoria;

    @NotNull(message = "La tienda no puede ser nula")
    @NotEmpty(message = "La tienda no puede estar vacia")
    private String tienda;

    @NotNull(message = "La cuenta de pago no puede ser nula")
    @NotEmpty(message = "La cuenta de pago no puede estar vacia")
    private String cuentaPago;

    @DecimalMin(value = "0.0", message = "El tax minimo es 0.0")
    private Double tax;

    public Gasto toEntity(Categoria categoria, Tienda tienda, CuentaPago cuentaPago) {
        Gasto gasto = new Gasto();
        gasto.setDescripcion(this.descripcion);
        gasto.setMonto(this.monto);
        gasto.setFecha(this.fecha);
        gasto.setTax(this.tax);

        gasto.setCategoria(categoria);
        gasto.setTienda(tienda);
        gasto.setCuentaPago(cuentaPago);

        return gasto;
    }

    public void updateEntity(Gasto gasto, Categoria categoria, Tienda tienda, CuentaPago cuentaPago) {
        gasto.setDescripcion(this.descripcion);
        gasto.setMonto(this.monto);
        gasto.setFecha(this.fecha);
        gasto.setTax(this.tax);
        gasto.setCategoria(categoria);
        gasto.setTienda(tienda);
        gasto.setCuentaPago(cuentaPago);
    }
}
