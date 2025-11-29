package com.gastini.gastini.controller;

import com.gastini.gastini.service.GastoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GastoController {
    private GastoService service;

    public GastoController(GastoService service) {
        this.service = service;
    }

    @GetMapping("/gastos")
    public void getAllGastos(){

    }

    @GetMapping("/gastos/id={id}")
    public void getGastosById(@PathVariable String id){

    }

    @GetMapping("/gastos/cat={categoria}")
    public void getGastosByCategoria(@PathVariable String categoria){

    }

    @GetMapping("/gastos/cta={cuenta}")
    public void getGastosByCuenta(@PathVariable String cuenta){

    }

    @GetMapping("/gastos/tienda={tienda}")
    public void getGastosByTienda(@PathVariable String tienda){

    }


}
