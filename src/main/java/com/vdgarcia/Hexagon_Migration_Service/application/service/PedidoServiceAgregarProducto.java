package com.vdgarcia.Hexagon_Migration_Service.application.service;

import com.vdgarcia.Hexagon_Migration_Service.application.dto.AgregarProductoDTO;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Pedido;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Producto;
import com.vdgarcia.Hexagon_Migration_Service.domain.repository.PedidoRepository;
import com.vdgarcia.Hexagon_Migration_Service.domain.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceAgregarProducto {

    private final PedidoRepository repository;
    private final ProductoRepository productoRepository;
    public PedidoServiceAgregarProducto(PedidoRepository repository, ProductoRepository productoRepository) {
        this.repository = repository;
        this.productoRepository = productoRepository;
    }

    public Pedido agregarProducto(AgregarProductoDTO dto){
        Pedido pedido = repository.obtenerId(dto.getPedidoId()).orElseThrow(
                ()->new IllegalArgumentException("Pedido no encontrado")
        );
        Producto producto = productoRepository.obtenerPorId(dto.getProductoId()).orElseThrow(
                ()-> new IllegalArgumentException("Producto no encontrado")
        );
        boolean stock = producto.validarStock(producto,dto.getCantidad());
        if(stock){
            throw new IllegalArgumentException("No hay suficiente Stock para el producto que intentas ingresar");
        }
        pedido.agregarProductos(producto,dto.getCantidad());

        Pedido agregado = repository.guardar(pedido);

        return pedido;
    }
}
