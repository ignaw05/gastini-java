package com.gastini.gastini.service;

import com.gastini.gastini.dto.DTOCategoriaRequest;
import com.gastini.gastini.dto.DTOCuentaPagoRequest;
import com.gastini.gastini.dto.DTOTiendaRequest;
import com.gastini.gastini.entity.Categoria;
import com.gastini.gastini.entity.CuentaPago;
import com.gastini.gastini.entity.Tienda;
import com.gastini.gastini.repository.CategoriaRepository;
import com.gastini.gastini.repository.CuentaPagoRepository;
import com.gastini.gastini.repository.TiendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParamService {
    private final CuentaPagoRepository cuentaPagoRepository;
    private final CategoriaRepository categoriaRepository;
    private final TiendaRepository tiendaRepository;

    public ParamService(CuentaPagoRepository cuentaPagoRepository, CategoriaRepository categoriaRepository,
            TiendaRepository tiendaRepository) {
        this.cuentaPagoRepository = cuentaPagoRepository;
        this.categoriaRepository = categoriaRepository;
        this.tiendaRepository = tiendaRepository;
    }

    public List<CuentaPago> getAllCuentasPago() {
        return cuentaPagoRepository.findAll();
    }

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public List<Tienda> getAllTiendas() {
        return tiendaRepository.findAll();
    }

    public CuentaPago createCuentaPago(DTOCuentaPagoRequest cuentaPagoDTO) {
        return cuentaPagoRepository.save(cuentaPagoDTO.toEntity());
    }

    public Categoria createCategoria(DTOCategoriaRequest categoriaDTO) {
        return categoriaRepository.save(categoriaDTO.toEntity());
    }

    public Tienda createTienda(DTOTiendaRequest tiendaDTO) {
        return tiendaRepository.save(tiendaDTO.toEntity());
    }

}
