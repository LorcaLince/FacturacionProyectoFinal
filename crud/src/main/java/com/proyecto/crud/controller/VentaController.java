package com.proyecto.crud.controller;


import com.proyecto.crud.models.schemas.Venta;
import com.proyecto.crud.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController

public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping(value = "/venta" ,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crearVenta(@RequestBody Venta venta) {
        try {
            Venta ventaCreada = ventaService.guardarVenta(venta);
            return ResponseEntity.created(URI.create("")).body(ventaCreada);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @GetMapping(value = "/venta/{venta_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarPorId(@PathVariable(name = "venta_id") Long cod_venta) {
        Optional<Venta> posibleVenta = ventaService.buscarPorId(cod_venta);

        if (posibleVenta.isPresent()) {
            return ResponseEntity.of(posibleVenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/venta/todas", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> todos() {
        return ResponseEntity.ok().body(ventaService.todos());
    }

    @DeleteMapping("/venta/{venta_id}")
    public ResponseEntity<?> borrarPorId(@PathVariable(name = "venta_id") Long cod_venta) {
        return ResponseEntity.ok().body("Venta con ID=" + cod_venta + "ha sido borrada");
    }


}

