package com.vdgarcia.Hexagon_Migration_Service.domain.mapper;

import com.vdgarcia.Hexagon_Migration_Service.api.dto.ClienteDTO;
import com.vdgarcia.Hexagon_Migration_Service.api.dto.DetallePedidoDTO;
import com.vdgarcia.Hexagon_Migration_Service.api.dto.PedidoDTO;
import com.vdgarcia.Hexagon_Migration_Service.api.dto.ProductoDTO;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Cliente;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.DetallePedido;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Pedido;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Producto;

import java.util.List;

public class MapperOne {

    public static ClienteDTO toClienteDTO(Cliente cliente){
        if (cliente==null) return null;
        List<PedidoDTO> pedidos = cliente.getPedidos().stream().map(MapperOne::toPedidoDTO).toList();
        return ClienteDTO.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .email(cliente.getEmail())
                .apellido(cliente.getApellido())
                .telefono(cliente.getTelefono())
                .pedidos(pedidos)
                .build();
    }

    public static PedidoDTO toPedidoDTO(Pedido pedido){
        if (pedido == null) return null;
        List<DetallePedidoDTO> detalles = pedido.getDetalles().stream().map(MapperOne::toDetallePedidoDTO).toList();
        return PedidoDTO.builder()
                .id(pedido.getId())
                .fecha(pedido.getFecha())
                .total(pedido.getTotal())
                .estado(pedido.getEstado())
                .cliente(pedido.getCliente().getId())
                .detalles(detalles)
                .build();
    }


    public static DetallePedidoDTO toDetallePedidoDTO(DetallePedido detalle){
        if (detalle == null) return null;
        return DetallePedidoDTO.builder()
                .id(detalle.getId())
                .pedido(detalle.getPedido().getId())
                .producto(detalle.getProducto().getId())
                .cantidad(detalle.getCantidad())
                .build();

    }



    public static ProductoDTO toProductoDTO(Producto producto){
        if (producto==null) return null;
        List<DetallePedidoDTO> detalles = producto.getDetalles().stream().map(MapperOne::toDetallePedidoDTO).toList();
        return ProductoDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .stock(producto.getStock())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .detalles(detalles)
                .build();
    }


    public static Cliente toCliente(ClienteDTO dto){
        if(dto == null) return null;
        List<Pedido> pedidos = dto.getPedidos().stream().map(MapperOne::toPedido).toList();
        return new Cliente(
                dto.getApellido(),
                dto.getEmail(),
                dto.getId(),
                dto.getNombre(),
                pedidos,
                dto.getTelefono()
        );
    }


    public static Pedido toPedido(PedidoDTO dto){
        if (dto==null) return null;
        List<DetallePedido> detalles = dto.getDetalles().stream().map(MapperOne::toDetallePedido).toList();
        return  new Pedido(
                dto.getFecha(),
                dto.getEstado(),
                detalles,
                new Cliente(dto.getId()),
                dto.getTotal()
        );
    }

    public static DetallePedido toDetallePedido(DetallePedidoDTO dto){
        if (dto==null) return null;
        return new DetallePedido(
                dto.getCantidad(),
                dto.getId(),
                new Pedido(dto.getPedido()),
                new Producto(dto.getProducto())
        );
    }


    public static Producto toProducto(ProductoDTO dto){
        if (dto == null) return null;
        List<DetallePedido> detalles = dto.getDetalles().stream().map(MapperOne::toDetallePedido).toList();
        return new Producto(dto.getDescripcion(), detalles, dto.getId(), dto.getNombre(), dto.getPrecio(), dto.getStock()
        );
    }











}
