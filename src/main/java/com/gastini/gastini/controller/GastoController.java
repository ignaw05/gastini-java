package com.gastini.gastini.controller;

import com.gastini.gastini.dto.DTOGastoRequest;
import com.gastini.gastini.dto.DTOGastoResponse;
import com.gastini.gastini.service.GastoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GastoController {
    private GastoService service;

    public GastoController(GastoService service) {
        this.service = service;
    }

    @GetMapping("/gastos")
    public List<DTOGastoResponse> getAllGastos() {
        List<DTOGastoResponse> gastos = service.getAllGastos();
        return gastos;
    }

    @GetMapping("/gastos/id={id}")
    public DTOGastoResponse getGastoById(@PathVariable Long id) {
        DTOGastoResponse gastos = service.getGastoById(id);
        return gastos;
    }

    @GetMapping("/gastos/cat={categoria}")
    public List<DTOGastoResponse> getGastosByCategoria(@PathVariable String categoria) {
        List<DTOGastoResponse> gastos = service.getGastosByCategoria(categoria);
        return gastos;
    }

    @GetMapping("/gastos/cta={cuenta}")
    public List<DTOGastoResponse> getGastosByCuenta(@PathVariable String cuenta) {
        List<DTOGastoResponse> gastos = service.getGastosByCuenta(cuenta);
        return gastos;
    }

    @GetMapping("/gastos/tienda={tienda}")
    public List<DTOGastoResponse> getGastosByTienda(@PathVariable String tienda) {
        List<DTOGastoResponse> gastos = service.getGastosByTienda(tienda);
        return gastos;
    }

    @PostMapping("/gastos")
    @ResponseStatus(HttpStatus.CREATED)
    public DTOGastoResponse createGasto(@Valid @RequestBody DTOGastoRequest gastoRequest) {
        return service.createGasto(gastoRequest);
    }

}
