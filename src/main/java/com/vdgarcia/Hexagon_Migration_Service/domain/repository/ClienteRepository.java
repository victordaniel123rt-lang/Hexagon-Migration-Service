package com.vdgarcia.Hexagon_Migration_Service.domain.repository;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    List<Cliente> obtenerTodos();
    Optional<Cliente> obtenerPorId(Long id);
    void eliminar(Long id);
    void guardar(Cliente cliente);
}
