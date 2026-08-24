package com.vdgarcia.Hexagon_Migration_Service.domain.dto;
import lombok.*;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class DetallePedidoDTO {

    private Long id;
    private Long producto;
    private Long pedido;
    private Integer cantidad;

}
