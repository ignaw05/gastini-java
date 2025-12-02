package com.gastini.gastini.dto;

import com.gastini.gastini.entity.Gasto;


public record DTOGastoResponse (
        Long id,
        String descripcion,
        String fecha,
        Double monto,
        Double tax,
        String categoria,
        String cuentaPago,
        String tienda
) {

    public static DTOGastoResponse fromEntity(Gasto gasto) {
        return new DTOGastoResponse(
                gasto.getId(),
                gasto.getDescripcion(),
                gasto.getFecha().toString(),
                gasto.getMonto(),
                gasto.getTax(),
                gasto.getCategoria() != null ? gasto.getCategoria().getNombre() : null,   // Check for null
                gasto.getCuentaPago() != null ? gasto.getCuentaPago().getNombre() : null, // Check for null
                gasto.getTienda() != null ? gasto.getTienda().getNombre() : null          // Check for null
        );
    }
}
