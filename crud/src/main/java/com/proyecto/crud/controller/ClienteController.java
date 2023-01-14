package com.proyecto.crud.controller;

import com.proyecto.crud.entity.Cliente;
import com.proyecto.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
        try {
            Cliente clienteCreado = clienteService.guardar(cliente);
            return ResponseEntity.created(URI.create("")).body(clienteCreado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @GetMapping(value = "/{cliente_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarPorId(@PathVariable(name = "cliente_id") Long cliente_id) {
        Optional<Cliente> posibleCliente = clienteService.buscarPorId(cliente_id);

        if (posibleCliente.isPresent()) {
            return ResponseEntity.of(posibleCliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/todos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> todos() {
        return ResponseEntity.ok().body(clienteService.todos());
    }

    @DeleteMapping("/{cliente_id}")
    public ResponseEntity<?> borrarPorId(@PathVariable(name = "cliente_id") Long cliente_id) {
        return ResponseEntity.ok().body("Cliente con ID=" + cliente_id + "ha sido borrado");
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> modificar(@RequestBody Cliente cliente) {
        try {
            Optional<Cliente> posibleCliente = clienteService.buscarPorId(cliente.getCliente_id());

            if (posibleCliente.isPresent()) {
                Cliente clienteGuardado = posibleCliente.get();
                clienteGuardado.setApellido(cliente.getApellido());
                clienteGuardado.setDni(cliente.getDni());
                clienteGuardado.setNombre(cliente.getNombre());
                clienteGuardado.setEdad(cliente.getEdad());

                clienteService.guardar(clienteGuardado);

                return ResponseEntity.ok().body(clienteGuardado);


            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
}



