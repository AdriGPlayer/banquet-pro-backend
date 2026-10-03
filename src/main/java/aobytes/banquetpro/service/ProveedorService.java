package aobytes.banquetpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aobytes.banquetpro.dto.ProveedorDTO;
import aobytes.banquetpro.models.ProveedorEntity;
import aobytes.banquetpro.repositories.ProveedorRepository;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Transactional
    public ProveedorEntity saveProveedor(ProveedorDTO dto) {
        ProveedorEntity entity = new ProveedorEntity();
        entity.setNombre(dto.getNombre());
        entity.setDireccion(dto.getDireccion());
        entity.setCorreo(dto.getCorreo());
        entity.setTelefono(dto.getTelefono());
        return proveedorRepository.save(entity);
    }

    public List<ProveedorEntity> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    public ProveedorEntity getProveedorById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Transactional
    public ProveedorEntity updateProveedor(Long id, ProveedorDTO dto) {
        ProveedorEntity entity = proveedorRepository.findById(id).orElse(null);
        if (entity == null) return null;
        entity.setNombre(dto.getNombre());
        entity.setDireccion(dto.getDireccion());
        entity.setCorreo(dto.getCorreo());
        entity.setTelefono(dto.getTelefono());
        return proveedorRepository.save(entity);
    }

    @Transactional
    public void deleteProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}
