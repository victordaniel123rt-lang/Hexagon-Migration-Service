package com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.repository;

import com.vdgarcia.Hexagon_Migration_Service.infraestructure.persistence.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoJpaRepository extends JpaRepository<ProductoEntity,Long>{
}
