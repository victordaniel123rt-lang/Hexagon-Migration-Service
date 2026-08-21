package com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.adapter;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Cliente;
import com.vdgarcia.Hexagon_Migration_Service.domain.repository.ClienteRepository;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity.ClienteEntity;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.mapper.Mapper;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.repository.ClienteJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteJpaRepository repository;

    @Override
    public List<Cliente> obtenerTodos() {
        return repository.findAll().stream().map(Mapper::toCliente).toList();
    }

    @Override
    public Optional<Cliente> obtenerPorId(Long id) {
        ClienteEntity cliente = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Cliente no encontrado")
        );
        return Optional.of(Mapper.toCliente(cliente));
    }

    @Override
    public Cliente crear(Cliente cliente) {
        ClienteEntity cliente1 = Mapper.toClienteEntity(cliente);
        ClienteEntity guardado = repository.save(cliente1);
        return Mapper.toCliente(guardado);
    }

    @Override
    public Cliente actualizar(Long id, Cliente cliente) {
        ClienteEntity cliente1 = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Cliente no encontrado")
        );
        Mapper.updateCliente(cliente,cliente1);
        ClienteEntity actualizado = repository.save(cliente1);
        return Mapper.toCliente(actualizado);
    }

    @Override
    public Cliente eliminar(Long id) {
        ClienteEntity cliente = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Cliente no encontrado")
        );
        repository.delete(cliente);
        return Mapper.toCliente(cliente);
    }
}
