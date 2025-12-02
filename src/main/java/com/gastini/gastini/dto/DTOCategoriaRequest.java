package com.gastini.gastini.dto;

import com.gastini.gastini.entity.Categoria;
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
public class DTOCategoriaRequest {

    @NotNull(message = "El nombre no puede ser nulo")
    @NotEmpty(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 255, message = "El nombre debe tener entre 3 y 255 caracteres")
    private String nombre;

    public Categoria toEntity() {
        Categoria categoria = new Categoria();
        categoria.setNombre(this.nombre);
        return categoria;
    }

    public void updateEntity(Categoria categoria) {
        categoria.setNombre(this.nombre);
    }
}
