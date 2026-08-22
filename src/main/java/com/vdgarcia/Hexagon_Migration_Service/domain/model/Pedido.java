package com.vdgarcia.Hexagon_Migration_Service.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private Long id;
    private Estado estado;
    private BigDecimal total;
    private LocalDate fecha;
    private Cliente cliente;
    private List<DetallePedido> detalles;


    public void agregarProductos(Producto producto, Integer cantidad){
        List<DetallePedido> detalles = this.getDetalles();
        DetallePedido detallePedido = new DetallePedido(cantidad,producto);
        detalles.add(detallePedido);
    }


    public Pedido(LocalDate fecha, Estado estado, List<DetallePedido> detalles, Cliente cliente, BigDecimal total) {
        this.fecha = fecha;
        this.estado = estado;
        this.detalles = detalles;
        this.cliente = cliente;
        this.total = total;
    }

    public Pedido(Long id) {
        this.id = id;
    }

    public Pedido(Cliente cliente, List<DetallePedido> detalles, Estado estado, LocalDate fecha, Long id, BigDecimal total) {
        this.cliente = cliente;
        this.detalles = detalles;
        this.estado = estado;
        this.fecha = fecha;
        this.id = id;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
