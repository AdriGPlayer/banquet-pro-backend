package aobytes.banquetpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aobytes.banquetpro.dto.ProveedorDTO;
import aobytes.banquetpro.models.ProveedorEntity;
import aobytes.banquetpro.service.ProveedorService;

@RestController
@RequestMapping("/banquetpro/api/proveedor")
@CrossOrigin(origins = "http://localhost:5173")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @PostMapping("/save")
    public ResponseEntity<ProveedorEntity> saveProveedor(@RequestBody ProveedorDTO dto) {
        return ResponseEntity.ok(proveedorService.saveProveedor(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProveedorEntity>> getAllProveedores() {
        return ResponseEntity.ok(proveedorService.getAllProveedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorEntity> getProveedorById(@PathVariable Long id) {
        ProveedorEntity p = proveedorService.getProveedorById(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorEntity> updateProveedor(@PathVariable Long id, @RequestBody ProveedorDTO dto) {
        ProveedorEntity updated = proveedorService.updateProveedor(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        proveedorService.deleteProveedor(id);
        return ResponseEntity.ok().build();
    }
}
