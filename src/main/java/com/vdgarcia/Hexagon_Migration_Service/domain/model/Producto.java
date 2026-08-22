package com.vdgarcia.Hexagon_Migration_Service.domain.model;

import java.math.BigDecimal;
import java.util.List;

public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private List<DetallePedido> detalles;

    public boolean validarStock(Producto producto, Integer cantidad){
        Integer stock = producto.getStock();
        if(stock<cantidad) return true;
        return false;
    }

    public void actualizarDatos(Producto producto){
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.stock = producto.getStock();
        this.descripcion = producto.getDescripcion();
    }

    public Producto(Long id) {
        this.id = id;
    }

    public Producto(String descripcion, List<DetallePedido> detalles, Long id, String nombre, BigDecimal precio, Integer stock) {
        this.descripcion = descripcion;
        this.detalles = detalles;
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
