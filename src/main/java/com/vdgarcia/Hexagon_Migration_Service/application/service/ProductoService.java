package com.vdgarcia.Hexagon_Migration_Service.application.service;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Producto;
import com.vdgarcia.Hexagon_Migration_Service.domain.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> obtenerTodos(){
        return repository.obtenerTodos();
    }

    public Producto obtenerPorId(Long id){
        return repository.obtenerPorId(id).orElseThrow(
                ()-> new IllegalArgumentException("Producto no encontrado")
        );
    }

    public Producto crear(Producto producto){
        return repository.guardar(producto);
    }

    public Producto actualizar(Long id, Producto producto){
        Producto producto1 = repository.obtenerPorId(id).orElseThrow(
                ()-> new IllegalArgumentException("Producto no encontrado")
        );
        producto1.actualizarDatos(producto);
        return repository.guardar(producto1);
    }

    public void eliminar(Long id){
        Producto producto = repository.obtenerPorId(id).orElseThrow(
                ()-> new IllegalArgumentException("Producto no encontrado")
        );
        repository.eliminar(id);
    }







}
