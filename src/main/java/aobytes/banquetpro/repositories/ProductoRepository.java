package aobytes.banquetpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aobytes.banquetpro.models.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
}
