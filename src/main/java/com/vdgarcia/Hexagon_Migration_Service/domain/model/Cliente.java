package com.vdgarcia.Hexagon_Migration_Service.domain.model;

import java.util.List;

public class Cliente {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private List<Pedido> pedidos;
}
