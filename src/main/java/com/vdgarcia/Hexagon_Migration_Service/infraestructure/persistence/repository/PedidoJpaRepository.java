package com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.repository;

import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJpaRepository extends JpaRepository<PedidoEntity,Long> {
}
