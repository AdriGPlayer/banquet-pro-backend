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

import aobytes.banquetpro.dto.ClienteDTO;
import aobytes.banquetpro.models.ClienteEntity;
import aobytes.banquetpro.service.ClienteService;

@RestController
@RequestMapping("/banquetpro/api/cliente")
@CrossOrigin(origins = "http://localhost:5173")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<ClienteEntity> saveCliente(@RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(clienteService.saveCliente(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAllClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> getClienteById(@PathVariable Long id) {
        ClienteEntity cliente = clienteService.getClienteById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        ClienteEntity updated = clienteService.updateCliente(id, dto);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.ok().build();
    }
}
