package com.vdgarcia.Hexagon_Migration_Service.domain.repository;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {

    List<Pedido> obtenerTodos();
    Optional<Pedido> obtenerId(Long id);
    Pedido guardar(Pedido pedido);
    Pedido eliminar(Long id);

}
