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
}
