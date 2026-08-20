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
}
