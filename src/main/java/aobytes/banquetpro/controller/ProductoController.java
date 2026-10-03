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

import aobytes.banquetpro.dto.ProductoDTO;
import aobytes.banquetpro.models.ProductoEntity;
import aobytes.banquetpro.service.ProductoService;

@RestController
@RequestMapping("/banquetpro/api/producto")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/save")
    public ResponseEntity<ProductoEntity> saveProducto(@RequestBody ProductoDTO dto) {
        return ResponseEntity.ok(productoService.saveProducto(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProductoEntity>> getAllProductos() {
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoEntity> getProductoById(@PathVariable Long id) {
        ProductoEntity p = productoService.getProductoById(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoEntity> updateProducto(@PathVariable Long id, @RequestBody ProductoDTO dto) {
        ProductoEntity updated = productoService.updateProducto(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.ok().build();
    }
}
