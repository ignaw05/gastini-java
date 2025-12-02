package com.gastini.gastini.service;

import com.gastini.gastini.dto.DTOGastoRequest;
import com.gastini.gastini.dto.DTOGastoResponse;
import com.gastini.gastini.entity.Categoria;
import com.gastini.gastini.entity.CuentaPago;
import com.gastini.gastini.entity.Gasto;
import com.gastini.gastini.entity.Tienda;
import com.gastini.gastini.repository.CategoriaRepository;
import com.gastini.gastini.repository.CuentaPagoRepository;
import com.gastini.gastini.repository.GastoRepository;
import com.gastini.gastini.repository.TiendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoService {
    private final GastoRepository repository;
    private final CategoriaRepository categoriaRepository;
    private final TiendaRepository tiendaRepository;
    private final CuentaPagoRepository cuentaPagoRepository;

    public GastoService(GastoRepository repository,
            CategoriaRepository categoriaRepository,
            TiendaRepository tiendaRepository,
            CuentaPagoRepository cuentaPagoRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
        this.tiendaRepository = tiendaRepository;
        this.cuentaPagoRepository = cuentaPagoRepository;
    }

    public DTOGastoResponse createGasto(DTOGastoRequest gastoRequest) throws Exception {
        // Buscar las entidades relacionadas por nombre
        Categoria categoria = categoriaRepository.findByNombre(gastoRequest.getCategoria());
        if (categoria == null) {
            throw new Exception("Categoria no encontrada: " + gastoRequest.getCategoria());
        }

        Tienda tienda = tiendaRepository.findByNombre(gastoRequest.getTienda());
        if (tienda == null) {
            throw new Exception("Tienda no encontrada: " + gastoRequest.getTienda());
        }

        CuentaPago cuentaPago = cuentaPagoRepository.findByNombre(gastoRequest.getCuentaPago());
        if (cuentaPago == null) {
            throw new Exception("Cuenta de pago no encontrada: " + gastoRequest.getCuentaPago());
        }

        // Crear el gasto con las entidades relacionadas
        Gasto gasto = gastoRequest.toEntity(categoria, tienda, cuentaPago);
        gasto = repository.save(gasto);
        return DTOGastoResponse.fromEntity(gasto);
    }

    public List<DTOGastoResponse> getAllGastos() {
        List<Gasto> gastos = repository.findAll();
        List<DTOGastoResponse> gastoResponses = gastos.stream().map(DTOGastoResponse::fromEntity)
                .sorted()
                .toList();
        return gastoResponses;
    }

    public List<DTOGastoResponse> getGastosByCategoria(String categoriaNombre) {
        Categoria categoria = categoriaRepository.findByNombre(categoriaNombre);
        List<Gasto> gastos = repository.findByCategoria(categoria);
        List<DTOGastoResponse> gastoResponses = gastos.stream().map(DTOGastoResponse::fromEntity)
                .sorted()
                .toList();
        return gastoResponses;
    }

    public List<DTOGastoResponse> getGastosByTienda(String tiendaNombre) {
        Tienda tienda = tiendaRepository.findByNombre(tiendaNombre);
        List<Gasto> gastos = repository.findByTienda(tienda);
        List<DTOGastoResponse> gastoResponses = gastos.stream().map(DTOGastoResponse::fromEntity)
                .sorted()
                .toList();
        return gastoResponses;
    }

    public List<DTOGastoResponse> getGastosByCuenta(String cuentaPago) {
        CuentaPago cuentaPago1 = cuentaPagoRepository.findByNombre(cuentaPago);
        List<Gasto> gastos = repository.findByCuentaPago(cuentaPago1);
        List<DTOGastoResponse> gastoResponses = gastos.stream().map(DTOGastoResponse::fromEntity)
                .sorted()
                .toList();
        return gastoResponses;
    }

    public DTOGastoResponse getGastoById(Long id) throws Exception {
        Gasto gasto = repository.findById(id).orElseThrow(() -> new Exception("Not found"));
        return DTOGastoResponse.fromEntity(gasto);
    }
}
