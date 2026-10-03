package aobytes.banquetpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aobytes.banquetpro.models.MovimientoEntity;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
}
