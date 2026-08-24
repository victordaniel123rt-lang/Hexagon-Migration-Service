package com.vdgarcia.Hexagon_Migration_Service.api.controller;


import com.vdgarcia.Hexagon_Migration_Service.api.dto.ProductoDTO;
import com.vdgarcia.Hexagon_Migration_Service.api.mapper.Mapper;
import com.vdgarcia.Hexagon_Migration_Service.application.service.ProductoService;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Producto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class PoductoController {

    private final ProductoService service;

    public PoductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerTodos(){
        List<ProductoDTO> productos = service.obtenerTodos()
                .stream()
                .map(Mapper::toProductoDTO)
                .toList();
        return ResponseEntity.ok(productos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(Mapper.toProductoDTO(service.obtenerPorId(id)));
    }


    @PostMapping
    public ResponseEntity<ProductoDTO> crear(@RequestBody Producto model){
        return ResponseEntity.ok(Mapper.toProductoDTO(service.crear(model)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizar(@PathVariable Long id, @RequestBody Producto model){
        return ResponseEntity.ok(Mapper.toProductoDTO(service.actualizar(id,model)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }


}
