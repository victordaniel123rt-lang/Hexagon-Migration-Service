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
        return repository.findById(id)
                .map(Mapper::toCliente);
    }

    @Override
    public void eliminar(Long id) {
      repository.deleteById(id);
    }

    @Override
    public void guardar(Cliente cliente) {
        ClienteEntity cliente1 = Mapper.toClienteEntity(cliente);
        ClienteEntity guardado = repository.save(cliente1);
    }
}
