package com.vdgarcia.Hexagon_Migration_Service.application.service;

import com.vdgarcia.Hexagon_Migration_Service.api.dto.ClienteDTO;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Cliente;
import com.vdgarcia.Hexagon_Migration_Service.domain.repository.ClienteRepository;
import com.vdgarcia.Hexagon_Migration_Service.api.mapper.Mapper;
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

    public ClienteDTO crear(ClienteDTO cliente){
        repository.guardar(cliente);
        return cliente;
    }

    public Cliente actualizar(Long id, ClienteDTO client){
        Cliente clien = repository.obtenerPorId(id).orElseThrow(
                ()-> new IllegalArgumentException("Cliente no encontrado")
        );
        Cliente cliente = Mapper.toCliente(client);
        clien.actualizarDatos(cliente);
        ClienteDTO c =Mapper.toClienteDTO(clien);
        repository.guardar(c);
        return clien;
    }

    public void eliminar(Long id){
        Cliente client = repository.obtenerPorId(id).orElseThrow(
                ()-> new IllegalArgumentException("Cliente no encontrado")
        );
     repository.eliminar(id);
    }

}
