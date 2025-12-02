package com.gastini.gastini.dto;

import com.gastini.gastini.entity.CuentaPago;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema
public class DTOCuentaPagoRequest {

    @NotNull(message = "El nombre no puede ser nulo")
    @NotEmpty(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 255, message = "El nombre debe tener entre 3 y 255 caracteres")
    private String nombre;

    public CuentaPago toEntity() {
        CuentaPago cuentaPago = new CuentaPago();
        cuentaPago.setNombre(this.nombre);
        return cuentaPago;
    }

    public void updateEntity(CuentaPago cuentaPago) {
        cuentaPago.setNombre(this.nombre);
    }
}
