package com.proyecto.crud.controller;


import com.proyecto.crud.models.schemas.Producto;
import com.proyecto.crud.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/Producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crear(@RequestBody Producto producto) {
        try {
            Producto productoCreado = productoService.guardar(producto);
            return ResponseEntity.created(URI.create("")).body(productoCreado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @GetMapping(value = "/{producto_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarPorId(@PathVariable(name = "producto_id") Long cod_producto) {
        Optional<Producto> posibleProducto = productoService.buscarPorId(cod_producto);

        if (posibleProducto.isPresent()) {
            return ResponseEntity.of(posibleProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> todos() {
        return ResponseEntity.ok().body(productoService.todos());
    }

    @DeleteMapping("/{producto_id}")
    public ResponseEntity<?> borrarPorId(@PathVariable(name = "producto_id") Long cod_producto) {
        return ResponseEntity.ok().body("Producto con ID=" + cod_producto + "ha sido borrado");
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> modificar(@RequestBody Producto producto) {
        try {
            Optional<Producto> posibleProducto = productoService.buscarPorId(producto.getCod_producto());

            if (posibleProducto.isPresent()) {
                Producto productoGuardado = posibleProducto.get();
                productoGuardado.setCantidad(producto.getCantidad());
                productoGuardado.setCodigo(producto.getCodigo());
                productoGuardado.setPrecio(producto.getPrecio());
                productoGuardado.setDescripcion(producto.getDescripcion());


                productoService.guardar(productoGuardado);

                return ResponseEntity.ok().body(productoGuardado);


            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
}
