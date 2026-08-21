package com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.adapter;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Producto;
import com.vdgarcia.Hexagon_Migration_Service.domain.repository.ProductoRepository;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity.ProductoEntity;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.mapper.Mapper;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.repository.ProductoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductoRepositoryAdapter implements ProductoRepository {

    private final ProductoJpaRepository repository;

    @Override
    public List<Producto> obtenerTodos() {
        return repository.findAll().stream().map(Mapper::toProducto).toList();
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id)
                .map(Mapper::toProducto);
    }

    @Override
    public Producto guardar(Producto producto) {
        ProductoEntity entity = Mapper.toProductoEntity(producto);
        ProductoEntity creado = repository.save(entity);
        return Mapper.toProducto(creado);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
