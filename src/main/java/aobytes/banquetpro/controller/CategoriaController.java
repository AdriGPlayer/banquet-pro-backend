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

import aobytes.banquetpro.dto.CategoriaDTO;
import aobytes.banquetpro.models.CategoriaEntity;
import aobytes.banquetpro.service.CategoriaService;

@RestController
@RequestMapping("/banquetpro/api/categoria")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/save")
    public ResponseEntity<CategoriaEntity> saveCategoria(@RequestBody CategoriaDTO dto) {
        return ResponseEntity.ok(categoriaService.saveCategoria(dto));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> getAllCategorias() {
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEntity> getCategoriaById(@PathVariable Long id) {
        CategoriaEntity c = categoriaService.getCategoriaById(id);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaEntity> updateCategoria(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        CategoriaEntity updated = categoriaService.updateCategoria(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.ok().build();
    }
}
