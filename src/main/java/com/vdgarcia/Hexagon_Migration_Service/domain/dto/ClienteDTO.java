package com.vdgarcia.Hexagon_Migration_Service.domain.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private List<PedidoDTO> pedidos;

}
