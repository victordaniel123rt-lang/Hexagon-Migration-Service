package com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Cliente;
import com.vdgarcia.Hexagon_Migration_Service.domain.model.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Estado estado;
    private BigDecimal total;
    private LocalDate fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
    private List<DetallePedidoEntity> detalles;
}
