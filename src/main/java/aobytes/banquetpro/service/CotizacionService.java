package aobytes.banquetpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aobytes.banquetpro.dto.CotizacionDTO;
import aobytes.banquetpro.dto.DetalleCotizacionDTO;
import aobytes.banquetpro.models.ClienteEntity;
import aobytes.banquetpro.models.CotizacionEntity;
import aobytes.banquetpro.models.DetalleCotizacion;
import aobytes.banquetpro.models.EvetoEntity;
import aobytes.banquetpro.models.ProductoEntity;
import aobytes.banquetpro.repositories.ClienteRepository;
import aobytes.banquetpro.repositories.CotizacionRepository;
import aobytes.banquetpro.repositories.DetalleCotizacionRepository;
import aobytes.banquetpro.repositories.EventoRepository;
import aobytes.banquetpro.repositories.ProductoRepository;

@Service
public class CotizacionService {
    @Autowired
    private CotizacionRepository cotizacionRepository;
    @Autowired
    private DetalleCotizacionRepository detalleRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public CotizacionEntity saveCotizacion(CotizacionDTO dto) {
        CotizacionEntity cot = new CotizacionEntity();
        if (dto.getIdCliente() != null) {
            ClienteEntity c = clienteRepository.findById(dto.getIdCliente()).orElse(null);
            cot.setCliente(c);
        }
        if (dto.getIdEvento() != null) {
            EvetoEntity e = eventoRepository.findById(dto.getIdEvento()).orElse(null);
            cot.setEvento(e);
        }
        cot.setFechaEvento(dto.getFechaEvento());
        cot.setEstatus(dto.getEstatus());
        cot.setTotal(dto.getTotal());
        cot.setPresupuestoCliente(dto.getPresupuestoCliente());
        CotizacionEntity saved = cotizacionRepository.save(cot);

        if (dto.getDetalles() != null) {
            for (DetalleCotizacionDTO d : dto.getDetalles()) {
                DetalleCotizacion det = new DetalleCotizacion();
                if (d.getIdEvento() != null) {
                    EvetoEntity e = eventoRepository.findById(d.getIdEvento()).orElse(null);
                    det.setEvento(e);
                }
                if (d.getIdProducto() != null) {
                    ProductoEntity p = productoRepository.findById(d.getIdProducto()).orElse(null);
                    det.setProducto(p);
                }
                det.setCantidad(d.getCantidad());
                det.setPrecioUnitario(d.getPrecioUnitario());
                det.setSubtotal(d.getSubtotal());
                detalleRepository.save(det);
            }
        }
        return saved;
    }

    public List<CotizacionEntity> getAllCotizaciones() {
        return cotizacionRepository.findAll();
    }

    public CotizacionEntity getCotizacionById(Long id) {
        return cotizacionRepository.findById(id).orElse(null);
    }

    public List<DetalleCotizacion> getDetallesByEvento(Long idEvento) {
        return detalleRepository.findByEventoId(idEvento);
    }
}
