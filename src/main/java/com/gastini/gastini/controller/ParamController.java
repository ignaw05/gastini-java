package com.gastini.gastini.controller;

import com.gastini.gastini.dto.DTOCategoriaRequest;
import com.gastini.gastini.dto.DTOCuentaPagoRequest;
import com.gastini.gastini.dto.DTOTiendaRequest;
import com.gastini.gastini.entity.Categoria;
import com.gastini.gastini.entity.CuentaPago;
import com.gastini.gastini.entity.Tienda;
import com.gastini.gastini.service.ParamService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParamController {
    private final ParamService service;

    public ParamController(ParamService service) {
        this.service = service;
    }

    // ==================== CATEGORIA ENDPOINTS ====================

    @GetMapping("/categorias")
    public List<Categoria> getAllCategorias() {
        return service.getAllCategorias();
    }

    @PostMapping("/categorias")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria createCategoria(@Valid @RequestBody DTOCategoriaRequest categoriaRequest) {
        return service.createCategoria(categoriaRequest);
    }

    // ==================== TIENDA ENDPOINTS ====================

    @GetMapping("/tiendas")
    public List<Tienda> getAllTiendas() {
        return service.getAllTiendas();
    }

    @PostMapping("/tiendas")
    @ResponseStatus(HttpStatus.CREATED)
    public Tienda createTienda(@Valid @RequestBody DTOTiendaRequest tiendaRequest) {
        return service.createTienda(tiendaRequest);
    }

    // ==================== CUENTA PAGO ENDPOINTS ====================

    @GetMapping("/cuentas-pago")
    public List<CuentaPago> getAllCuentasPago() {
        return service.getAllCuentasPago();
    }

    @PostMapping("/cuentas-pago")
    @ResponseStatus(HttpStatus.CREATED)
    public CuentaPago createCuentaPago(@Valid @RequestBody DTOCuentaPagoRequest cuentaPagoRequest) {
        return service.createCuentaPago(cuentaPagoRequest);
    }
}
