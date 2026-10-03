package aobytes.banquetpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aobytes.banquetpro.dto.EmpleadoDTO;
import aobytes.banquetpro.models.EmpleadoEntity;
import aobytes.banquetpro.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Transactional
    public EmpleadoEntity saveEmpleado(EmpleadoDTO dto) {
        EmpleadoEntity entity = new EmpleadoEntity();
        entity.setNombre(dto.getNombre());
        entity.setApellidoP(dto.getApellidoP());
        entity.setApellidoM(dto.getApellidoM());
        entity.setTelefono(dto.getTelefono());
        entity.setRol(dto.getRol());
        entity.setDisponibilidad(dto.getDisponibilidad());
        return empleadoRepository.save(entity);
    }

    public List<EmpleadoEntity> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public EmpleadoEntity getEmpleadoById(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Transactional
    public EmpleadoEntity updateEmpleado(Long id, EmpleadoDTO dto) {
        EmpleadoEntity entity = empleadoRepository.findById(id).orElse(null);
        if (entity == null) return null;
        entity.setNombre(dto.getNombre());
        entity.setApellidoP(dto.getApellidoP());
        entity.setApellidoM(dto.getApellidoM());
        entity.setTelefono(dto.getTelefono());
        entity.setRol(dto.getRol());
        entity.setDisponibilidad(dto.getDisponibilidad());
        return empleadoRepository.save(entity);
    }

    @Transactional
    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}
