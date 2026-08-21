package com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.repository;

import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity,Long>{
}
