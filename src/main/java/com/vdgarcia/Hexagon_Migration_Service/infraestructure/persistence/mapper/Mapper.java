package com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.mapper;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Cliente;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.DetallePedido;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Pedido;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Producto;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity.ClienteEntity;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity.DetallePedidoEntity;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity.PedidoEntity;
import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity.ProductoEntity;

import java.util.List;

public class Mapper {

    public static Cliente toCliente(ClienteEntity entity){
        if(entity==null) return null;
        List<Pedido> pedidos = entity.getPedidos().stream().map(Mapper::toPedido).toList();
        return new Cliente(
                entity.getApellido(),
                entity.getEmail(),
                entity.getId(),
                entity.getNombre(),
                pedidos,
                entity.getTelefono()
        );

    }

    public static ClienteEntity toClienteEntity(Cliente model){
        if(model == null) return null;
        List<PedidoEntity> pedidos = model.getPedidos().stream().map(Mapper::toPedidoEntity).toList();
        return ClienteEntity.builder()
                .id(model.getId())
                .nombre(model.getNombre())
                .apellido(model.getApellido())
                .email(model.getEmail())
                .telefono(model.getTelefono())
                .pedidos(pedidos)
                .build();


    }

    public static Pedido toPedido(PedidoEntity entity){
        if(entity==null) return null;
        List<DetallePedido> detalles = entity.getDetalles().stream().map(Mapper::toDetallePedido).toList();
        return new Pedido(
                new Cliente(entity.getCliente().getId()),
                detalles,
                entity.getEstado(),
                entity.getFecha(),
                entity.getId(),
                entity.getTotal()
        );

    }


    public static PedidoEntity toPedidoEntity(Pedido model){
        if(model== null) return null;
        List<DetallePedidoEntity> detalles = model.getDetalles().stream().map(Mapper::toDetallePedidoEntity).toList();
        return PedidoEntity.builder()
                .id(model.getId())
                .cliente(ClienteEntity.builder().id(model.getCliente().getId()).build())
                .total(model.getTotal())
                .fecha(model.getFecha())
                .estado(model.getEstado())
                .detalles(detalles)
                .build();

    }


    public static DetallePedido toDetallePedido(DetallePedidoEntity entity){
        if (entity==null) return null;

        return new DetallePedido(
                entity.getCantidad(),
                entity.getId(),
                new Pedido(entity.getPedido().getId()),
                new Producto(entity.getProducto().getId())
        );

    }

    public static DetallePedidoEntity toDetallePedidoEntity(DetallePedido model){
        if(model == null) return null;
        return DetallePedidoEntity.builder()
                .id(model.getId())
                .pedido(PedidoEntity.builder().id(model.getPedido().getId()).build())
                .producto(ProductoEntity.builder().id(model.getProducto().getId()).build())
                .cantidad(model.getCantidad())
                .build();

    }



    public static Producto toProducto(ProductoEntity entity){
        if (entity==null) return null;
        List<DetallePedido> detalles = entity.getDetalles().stream().map(Mapper::toDetallePedido).toList();
        return new Producto(
                entity.getDescripcion(),
                detalles,
                entity.getId(),
                entity.getNombre(),
                entity.getPrecio(),
                entity.getStock()
        );

    }


    public static ProductoEntity toProductoEntity(Producto model){
        if(model == null) return null;
        List<DetallePedidoEntity> detalles = model.getDetalles().stream().map(Mapper::toDetallePedidoEntity).toList();
        return ProductoEntity.builder()
                .id(model.getId())
                .nombre(model.getNombre())
                .descripcion(model.getDescripcion())
                .stock(model.getStock())
                .precio(model.getPrecio())
                .detalles(detalles)
                .build();

    }









}
