package com.gastini.gastini.dto;

import com.gastini.gastini.entity.Gasto;
import com.gastini.gastini.entity.Ingreso;

public record DTOIngresoResponse (
        Long id,
        String descripcion,
        String fecha,
        Double monto,
        Double tax,
        String cuentaPago
){
    public static DTOIngresoResponse fromEntity(Ingreso ingreso){
        return new DTOIngresoResponse(
                ingreso.getId(),
                ingreso.getDescripcion(),
                ingreso.getFecha().toString(),
                ingreso.getMonto(),
                ingreso.getTax(),
                ingreso.getCuentaPago().getNombre()
        );
    }
}
