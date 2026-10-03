package aobytes.banquetpro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import aobytes.banquetpro.models.EvetoEntity;
import aobytes.banquetpro.models.enums.EstadoEvento;

public interface EventoRepository extends JpaRepository<EvetoEntity, Long>{
    List<EvetoEntity> findByEstatus(EstadoEvento estatus);
}
