package aobytes.banquetpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aobytes.banquetpro.dto.MovimientoDTO;
import aobytes.banquetpro.models.MovimientoEntity;
import aobytes.banquetpro.service.MovimientoService;

@RestController
@RequestMapping("/banquetpro/api/movimiento")
@CrossOrigin(origins = "http://localhost:5173")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @PostMapping("/save")
    public ResponseEntity<MovimientoEntity> saveMovimiento(@RequestBody MovimientoDTO dto) {
        return ResponseEntity.ok(movimientoService.saveMovimiento(dto));
    }

    @GetMapping
    public ResponseEntity<List<MovimientoEntity>> getAllMovimientos() {
        return ResponseEntity.ok(movimientoService.getAllMovimientos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoEntity> getMovimientoById(@PathVariable Long id) {
        MovimientoEntity m = movimientoService.getMovimientoById(id);
        if (m == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        movimientoService.deleteMovimiento(id);
        return ResponseEntity.ok().build();
    }
}
