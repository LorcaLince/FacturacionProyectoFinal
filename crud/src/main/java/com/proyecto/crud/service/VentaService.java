package com.proyecto.crud.service;


import com.proyecto.crud.models.schemas.Venta;

import com.proyecto.crud.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    /**
     * Esta funcion va a crear un nuevo registro en caso de que el cliente no exista. Si la id existem entonces actualiza el registro.
     * @param venta
     * @return
     */
    public Venta guardarVenta(Venta venta){
        return ventaRepository.save(venta);

    }
    public Optional<Venta> buscarPorId(Long cod_venta){
        return ventaRepository.findById(cod_venta);
    }
    public List<Venta> todos(){
        return ventaRepository.findAll();
    }

    public void borrarPorId(Long cod_venta){
        ventaRepository.deleteById(cod_venta);
    }

    }