package aobytes.banquetpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aobytes.banquetpro.models.EvetoEntity;

public interface EventoRepository extends JpaRepository<EvetoEntity, Long>{
    
}
