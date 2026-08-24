package com.vdgarcia.Hexagon_Migration_Service.api.controller;

import com.vdgarcia.Hexagon_Migration_Service.api.dto.PedidoDTO;
import com.vdgarcia.Hexagon_Migration_Service.api.mapper.Mapper;
import com.vdgarcia.Hexagon_Migration_Service.application.dto.AgregarProductoDTO;
import com.vdgarcia.Hexagon_Migration_Service.application.service.PedidoService;
import com.vdgarcia.Hexagon_Migration_Service.application.service.PedidoServiceAgregarProducto;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService service;
    private final PedidoServiceAgregarProducto agregarProducto;

    public PedidoController(PedidoService service, PedidoServiceAgregarProducto agregarProducto) {
        this.service = service;
        this.agregarProducto = agregarProducto;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> obtenerTodos(){
        return ResponseEntity.ok(
                service.obtenerTodos()
                        .stream()
                        .map(Mapper::toPedidoDTO)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(Mapper.toPedidoDTO(service.obtenerPorId(id)));
    }


    @PostMapping
    public ResponseEntity<PedidoDTO> crear(@RequestBody Pedido model){
        return ResponseEntity.ok(Mapper.toPedidoDTO(model));
    }

    @PostMapping("/agregar")
    public ResponseEntity<PedidoDTO> agregar(@RequestBody AgregarProductoDTO dto){
        return ResponseEntity.ok(Mapper.toPedidoDTO(agregarProducto.agregarProducto(dto)));
    }


}
