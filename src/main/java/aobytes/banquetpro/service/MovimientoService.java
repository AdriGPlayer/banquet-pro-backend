package aobytes.banquetpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aobytes.banquetpro.dto.MovimientoDTO;
import aobytes.banquetpro.models.MovimientoEntity;
import aobytes.banquetpro.repositories.MovimientoRepository;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    @Transactional
    public MovimientoEntity saveMovimiento(MovimientoDTO dto) {
        MovimientoEntity entity = new MovimientoEntity();
        entity.setConcepto(dto.getConcepto());
        entity.setTipo(dto.getTipo());
        entity.setMonto(dto.getMonto());
        entity.setFecha(dto.getFecha());
        return movimientoRepository.save(entity);
    }

    public List<MovimientoEntity> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    public MovimientoEntity getMovimientoById(Long id) {
        return movimientoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
}
