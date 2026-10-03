package aobytes.banquetpro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import aobytes.banquetpro.models.DetalleCotizacion;

public interface DetalleCotizacionRepository extends JpaRepository<DetalleCotizacion, Long> {
    List<DetalleCotizacion> findByEventoId(Long idEvento);
}
