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
        ProductoEntity entity = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Producto no encontrado")
        );
        return Optional.of(Mapper.toProducto(entity));
    }

    @Override
    public Producto crear(Producto producto) {
        ProductoEntity entity = Mapper.toProductoEntity(producto);
        ProductoEntity creado = repository.save(entity);
        return Mapper.toProducto(creado);
    }

    @Override
    public Producto actualizar(Long id, Producto producto) {
        ProductoEntity entity = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Producto no encontrado")
        );
        Mapper.updateProducto(producto,entity);
        ProductoEntity actualizado = repository.save(entity);
        return Mapper.toProducto(actualizado);
    }

    @Override
    public Producto eliminar(Long id) {
        ProductoEntity entity = repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Producto no encontrado")
        );
        repository.delete(entity);
        return Mapper.toProducto(entity);
    }
}
