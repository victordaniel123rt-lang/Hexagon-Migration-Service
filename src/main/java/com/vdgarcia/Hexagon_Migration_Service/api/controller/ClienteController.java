package com.vdgarcia.Hexagon_Migration_Service.api.controller;

import com.vdgarcia.Hexagon_Migration_Service.api.dto.ClienteDTO;
import com.vdgarcia.Hexagon_Migration_Service.api.mapper.Mapper;
import com.vdgarcia.Hexagon_Migration_Service.application.service.ClienteService;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Cliente;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> obtenerTodos(){
        return ResponseEntity.ok(service.obtenerTodos().stream().map(Mapper::toClienteDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerPorId(@PathVariable Long id){
        ClienteDTO dto = Mapper.toClienteDTO(service.obtenerId(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> crear(@RequestBody Cliente model){
        return ResponseEntity.ok(Mapper.toClienteDTO(service.crear(model)));
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> actualizar(@PathVariable Long id, @RequestBody Cliente model){
        return ResponseEntity.ok(Mapper.toClienteDTO(service.actualizar(id,model)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }





}
