package com.vdgarcia.Hexagon_Migration_Service.domain.repository;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {

    List<Producto> obtenerTodos();
    Optional<Producto> obtenerPorId(Long id);
    Producto crear(Producto producto);
    Producto actualizar(Long id, Producto producto);
    Producto eliminar(Long id);
}
