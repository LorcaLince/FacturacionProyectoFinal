package com.proyecto.crud.service;


import com.proyecto.crud.models.schemas.Cliente;
import com.proyecto.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Esta funcion va a crear un nuevo registro en caso de que el cliente no exista. Si la id existem entonces actualiza el registro.
     * @param cliente
     * @return
     */
    public Cliente guardar(Cliente cliente){
        return clienteRepository.save(cliente);

    }
    public Optional<Cliente> buscarPorId(Long cliente_id){
        return clienteRepository.findById(cliente_id);
    }
    public List<Cliente> todos(){
        return clienteRepository.findAll();
    }

    public void borrarPorId(Long cliente_id){
        clienteRepository.deleteById(cliente_id);
    }
}
