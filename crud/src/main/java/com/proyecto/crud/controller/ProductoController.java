package com.proyecto.crud.controller;


import com.proyecto.crud.models.schemas.Producto;
import com.proyecto.crud.service.ProductoService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController

public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @PostMapping(value = "/producto",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        try {
            Producto productoCreado = productoService.guardarProducto(producto);
            return ResponseEntity.created(URI.create("")).body(productoCreado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @GetMapping(value = "/producto/{producto_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarPorIdProducto(@PathVariable(name = "producto_id") Long cod_producto) {
        Optional<Producto> posibleProducto = productoService.buscarPorIdProducto(cod_producto);

        if (posibleProducto.isPresent()) {
            return ResponseEntity.of(posibleProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/producto/todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> productoTodos() {
        return ResponseEntity.ok().body(productoService.productoTodos());
    }

    @DeleteMapping("/producto/{producto_id}")
    public ResponseEntity<?> borrarPorIdProducto(@PathVariable(name = "producto_id") Long cod_producto) {
        return ResponseEntity.ok().body("Producto con ID=" + cod_producto + "ha sido borrado");
    }


}

