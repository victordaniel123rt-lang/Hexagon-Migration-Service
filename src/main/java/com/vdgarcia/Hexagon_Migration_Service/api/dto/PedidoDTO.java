package com.vdgarcia.Hexagon_Migration_Service.api.dto;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Estado;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class PedidoDTO {

    private Long id;
    private Estado estado;
    private BigDecimal total;
    private LocalDate fecha;
    private Long cliente;
    private List<DetallePedidoDTO> detalles;

}
