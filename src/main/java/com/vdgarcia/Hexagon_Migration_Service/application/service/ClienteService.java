package com.vdgarcia.Hexagon_Migration_Service.application.service;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Cliente;
import com.vdgarcia.Hexagon_Migration_Service.domain.repository.ClienteRepository;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> obtenerTodos(){
        return repository.obtenerTodos();
    }

    public Cliente obtenerId(Long id){
        return repository.obtenerPorId(id).orElseThrow(
                ()-> new IllegalArgumentException("Cliente no encontrado")
        );
    }

    public Cliente crear(Cliente cliente){
        repository.guardar(cliente);
        return cliente;
    }

    public Cliente actualizar(Long id, Cliente cliente){
        Cliente client = repository.obtenerPorId(id).orElseThrow(
                ()-> new IllegalArgumentException("Cliente no encontrado")
        );
        client.actualizarDatos(cliente);
        repository.guardar(client);
        return client;
    }

    public void eliminar(Long id){
        Cliente client = repository.obtenerPorId(id).orElseThrow(
                ()-> new IllegalArgumentException("Cliente no encontrado")
        );
     repository.eliminar(id);
    }

}
