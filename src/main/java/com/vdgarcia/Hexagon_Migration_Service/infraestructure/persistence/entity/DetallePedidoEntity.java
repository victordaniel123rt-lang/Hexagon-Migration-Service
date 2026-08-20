package com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "detalles")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class DetallePedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="producto_id")
    private ProductoEntity producto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;


}
