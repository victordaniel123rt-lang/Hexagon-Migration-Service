package com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.adapter;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Pedido;
import com.vdgarcia.Hexagon_Migration_Service.domain.repository.PedidoRepository;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity.PedidoEntity;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.mapper.Mapper;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.repository.PedidoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PedidoRepositoryAdapter implements PedidoRepository {

    private final PedidoJpaRepository repository;

    @Override
    public List<Pedido> obtenerTodos() {
        return repository.findAll().stream().map(Mapper::toPedido).toList();
    }

    @Override
    public Optional<Pedido> obtenerId(Long id) {
        PedidoEntity entity = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Pedido no encontrado")
        );
        return Optional.of(Mapper.toPedido(entity));
    }

    @Override
    public Pedido crear(Pedido pedido) {
        PedidoEntity entity = Mapper.toPedidoEntity(pedido);
        PedidoEntity creado = repository.save(entity);
        return Mapper.toPedido(creado);
    }

    @Override
    public Pedido actualizar(Long id, Pedido pedido) {
        PedidoEntity entity = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Pedido no encontrado")
        );
        Mapper.updatePedido(pedido,entity);
        PedidoEntity actualizado = repository.save(entity);
        return Mapper.toPedido(actualizado);
    }

    @Override
    public Pedido eliminar(Long id) {
        PedidoEntity entity = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Pedido no encontrado")
        );
        repository.delete(entity);
        return Mapper.toPedido(entity);
    }
}
