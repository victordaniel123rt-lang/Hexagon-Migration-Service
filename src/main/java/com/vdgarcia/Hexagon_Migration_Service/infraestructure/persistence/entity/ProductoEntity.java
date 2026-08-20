package com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "producto")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
    private List<DetallePedidoEntity> detalles;

}
