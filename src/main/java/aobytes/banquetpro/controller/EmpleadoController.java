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

import aobytes.banquetpro.dto.EmpleadoDTO;
import aobytes.banquetpro.models.EmpleadoEntity;
import aobytes.banquetpro.service.EmpleadoService;

@RestController
@RequestMapping("/banquetpro/api/empleado")
@CrossOrigin(origins = "http://localhost:5173")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/save")
    public ResponseEntity<EmpleadoEntity> saveEmpleado(@RequestBody EmpleadoDTO dto) {
        return ResponseEntity.ok(empleadoService.saveEmpleado(dto));
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoEntity>> getAllEmpleados() {
        return ResponseEntity.ok(empleadoService.getAllEmpleados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoEntity> getEmpleadoById(@PathVariable Long id) {
        EmpleadoEntity e = empleadoService.getEmpleadoById(id);
        if (e == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(e);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoEntity> updateEmpleado(@PathVariable Long id, @RequestBody EmpleadoDTO dto) {
        EmpleadoEntity updated = empleadoService.updateEmpleado(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
        return ResponseEntity.ok().build();
    }
}
