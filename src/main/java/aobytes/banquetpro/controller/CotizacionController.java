package aobytes.banquetpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aobytes.banquetpro.dto.CotizacionDTO;
import aobytes.banquetpro.models.CotizacionEntity;
import aobytes.banquetpro.models.DetalleCotizacion;
import aobytes.banquetpro.service.CotizacionService;

@RestController
@RequestMapping("/banquetpro/api/cotizacion")
@CrossOrigin(origins = "http://localhost:5173")
public class CotizacionController {
    @Autowired
    private CotizacionService cotizacionService;

    @PostMapping("/save")
    public ResponseEntity<CotizacionEntity> saveCotizacion(@RequestBody CotizacionDTO dto) {
        return ResponseEntity.ok(cotizacionService.saveCotizacion(dto));
    }

    @GetMapping
    public ResponseEntity<List<CotizacionEntity>> getAllCotizaciones() {
        return ResponseEntity.ok(cotizacionService.getAllCotizaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CotizacionEntity> getCotizacionById(@PathVariable Long id) {
        CotizacionEntity c = cotizacionService.getCotizacionById(id);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c);
    }

    @GetMapping("/{idEvento}/detalles")
    public ResponseEntity<List<DetalleCotizacion>> getDetallesByEvento(@PathVariable Long idEvento) {
        return ResponseEntity.ok(cotizacionService.getDetallesByEvento(idEvento));
    }
}
