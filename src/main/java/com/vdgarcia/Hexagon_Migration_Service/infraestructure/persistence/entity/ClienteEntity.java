package com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity;

import com.vdgarcia.Hexagon_Migration_Service.domain.model.Pedido;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cliente")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<PedidoEntity> pedidos;

}
