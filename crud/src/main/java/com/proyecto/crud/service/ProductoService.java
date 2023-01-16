package com.proyecto.crud.service;

import com.proyecto.crud.models.schemas.Producto;
import com.proyecto.crud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Esta funcion va a crear un nuevo registro en caso de que el producto no exista. Si la id existem entonces actualiza el registro.
     * @param producto
     * @return
     */
    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);

    }
    public Optional<Producto> buscarPorIdProducto(Long cod_producto){
        return productoRepository.findById(cod_producto);
    }
    public List<Producto> productoTodos(){
        return productoRepository.findAll();
    }

    public void borrarPorIdProducto(Long cod_producto){
        productoRepository.deleteById(cod_producto);
    }
}