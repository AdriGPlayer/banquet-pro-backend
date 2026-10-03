package aobytes.banquetpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aobytes.banquetpro.models.ProveedorEntity;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {
}
