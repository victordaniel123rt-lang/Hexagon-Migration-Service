package com.vdgarcia.Hexagon_Migration_Service.application.service;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Cliente;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Estado;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Pedido;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Producto;
import com.vdgarcia.Hexagon_Migration_Service.domain.repository.ClienteRepository;
import com.vdgarcia.Hexagon_Migration_Service.domain.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository repository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    public List<Pedido> obtenerTodos(){
        return repository.obtenerTodos();
    }

    public Pedido obtenerPorId(Long id){
        return  repository.obtenerId(id).orElseThrow(
                ()-> new IllegalArgumentException("Pedido no encontrado")
        );
    }

    public Pedido crear(Pedido pedido){
        Cliente cliente = clienteRepository.obtenerPorId(pedido.getCliente().getId()).orElseThrow(
                ()-> new IllegalArgumentException("Cliente no encontrado")
        );
        Pedido pedido1 = new Pedido(
                LocalDate.now(),
                Estado.RECIBIDO,
                new ArrayList<>(),
                cliente,
                BigDecimal.valueOf(0.0)
        );
        Pedido creado = repository.guardar(pedido1);
        return creado;
    }





}
