package com.proyecto.crud.controller;


import com.proyecto.crud.entity.Venta;
import com.proyecto.crud.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crear(@RequestBody Venta venta) {
        try {
            Venta ventaCreada = ventaService.guardar(venta);
            return ResponseEntity.created(URI.create("")).body(ventaCreada);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @GetMapping(value = "/{venta_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarPorId(@PathVariable(name = "venta_id") Long cod_venta) {
        Optional<Venta> posibleVenta = ventaService.buscarPorId(cod_venta);

        if (posibleVenta.isPresent()) {
            return ResponseEntity.of(posibleVenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> todos() {
        return ResponseEntity.ok().body(ventaService.todos());
    }

    @DeleteMapping("/{producto_id}")
    public ResponseEntity<?> borrarPorId(@PathVariable(name = "venta_id") Long cod_venta) {
        return ResponseEntity.ok().body("Venta con ID=" + cod_venta + "ha sido borrada");
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> modificar(@RequestBody Venta venta) {
        try {
            Optional<Venta> posibleVenta = ventaService.buscarPorId(venta.getCod_venta());

            if (posibleVenta.isPresent()) {
                Venta ventaGuardada = posibleVenta.get();
                ventaGuardada.setCantidad(venta.getCantidad());
                ventaGuardada.setDescripcion(venta.getDescripcion());
                ventaGuardada.setPrecio(venta.getPrecio());
                ventaGuardada.setProducto(venta.getProducto());
                ventaGuardada.setCliente(venta.getCliente());


                ventaService.guardar(ventaGuardada);

                return ResponseEntity.ok().body(ventaGuardada);


            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
}

